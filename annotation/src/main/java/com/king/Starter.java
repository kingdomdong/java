package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.king.configuration.TestBean;

@Configuration
@SpringBootApplication(scanBasePackages = "com.king")
public class Starter {
	
	public static void main(String[] args) {
//	@SuppressWarnings("resource")
//		ApplicationContext context = new AnnotationConfigApplicationContext(ComConfiguration.class);
//
//		ComBean cBean = (ComBean) context.getBean("comBean");
//		System.out.println(cBean);
		
		SpringApplication.run(Starter.class, args);
	}
	
	@Bean
	public TestBean testBean() {
		TestBean tBean = new TestBean();
		tBean.setUsername("ComBean test username");
		
		return tBean;
	}

}
