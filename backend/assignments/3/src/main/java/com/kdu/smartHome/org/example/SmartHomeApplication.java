package org.example;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.dao")
@EntityScan(basePackages = "org.example")
@ComponentScan(basePackages = "org.example")
public class SmartHomeApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SmartHomeApplication.class, args);
    }
}
