package com.middleware.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MiddlewareApplication {
	public static void main(String[] args) {
	    SpringApplication.run(MiddlewareApplication.class, args);
	}
}
