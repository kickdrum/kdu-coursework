package com.example.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Springboot3Application {
	public static final Logger slf4jLogger = LoggerFactory.getLogger(Springboot3Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Springboot3Application.class, args);
	}
}
