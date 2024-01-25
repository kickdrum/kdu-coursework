package com.example.springhandson4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringHandson4Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringHandson4Application.class).profiles("prod").run(args);
	}

}
