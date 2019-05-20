package com.king.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = { "application/json; charset=UTF-8" })
public class TestController {

	@GetMapping(value = "/hello")
	public String get() {
		return "Hello World!";
	}
	
}
