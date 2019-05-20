package com.king.component.bean;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.king.component.bean")
public class ComConfiguration {

	public ComConfiguration() {
		System.out.println("Spring container ComConfiguration is initializing ...");
	}
	
}
