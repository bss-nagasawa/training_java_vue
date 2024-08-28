package com.spring.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring.demo")
public class Users {
	public static void main(String[] args) {
		SpringApplication.run(Users.class, args);
	}
}