package com.king.bean.config;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplateConfig {
	
	@Bean
	public TestRestTemplate template() {
		return new TestRestTemplate();
	}

}
