package com.example.prashantminiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.prashantminiproject")
//@ComponentScan
@EntityScan(basePackages = "com.example.prashantminiproject.model")
public class PrashantMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrashantMiniProjectApplication.class, args);
	}

}
