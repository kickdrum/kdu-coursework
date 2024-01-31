package com.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringJDBCApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCApplication.class, args);
		log.info("Application Started...");
	}
}
