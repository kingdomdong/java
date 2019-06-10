package com.king.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.king.base.Greeting;
import com.king.pojo.User;
import com.king.service.PropertyService;

@RestController
@RequestMapping(value = "/greeting", produces = { "application/json; charset=UTF-8" })
public class GreetingController {
	
	private static Logger log = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	private PropertyService ptService;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/*
	 *  @RequestMapping maps all HTTP operations by default
	 *  But Post json parameters don't work
	 */
	@RequestMapping(value = "/back")
	public Greeting greenting(@RequestParam(value="name", defaultValue="World") String name) {
		log.info("greeting api starts and parameter is {}", counter + " " + name);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping("/admin")
	public User user() {
		return ptService.getAdmin();
	}

}
