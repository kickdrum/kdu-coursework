package com.example.prashantjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class PrashantJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrashantJpaApplication.class, args);
	}

}
