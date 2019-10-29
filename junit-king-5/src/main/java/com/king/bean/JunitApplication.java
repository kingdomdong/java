package com.king.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.king")
@EnableFeignClients
public class JunitApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);
	}
	
}
