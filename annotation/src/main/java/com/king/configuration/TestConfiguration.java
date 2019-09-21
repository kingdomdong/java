package com.king.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TestConfiguration {

	public TestConfiguration() {
		System.out.println("spring container TestConfiguration is initializing ...");
	}

//	@Bean
//	public TestBean testBean() {
//		TestBean testBean = new TestBean();
//		testBean.setUsername("kingdomdong");
//		testBean.setPassword("******");
//		testBean.setUrl("http://kingdomdong.com");
//
//		return testBean;
//	}

}
