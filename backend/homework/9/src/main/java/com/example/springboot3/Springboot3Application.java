package com.example.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Springboot3Application {
	public static final Logger slf4jLogger = LoggerFactory.getLogger(Springboot3Application.class);
	public static void main(String[] args) {
		new SpringApplicationBuilder(Springboot3Application.class).profiles("prod").run(args);
	}
}
