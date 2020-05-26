package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot application
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-08 15:55:59
 */
@SpringBootApplication(scanBasePackages = "com.king")
public class Java8Application {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

}
