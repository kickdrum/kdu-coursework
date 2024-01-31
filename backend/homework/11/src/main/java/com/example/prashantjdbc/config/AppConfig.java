package com.example.prashantjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Objects;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/prashantjdbc");
        driverManagerDataSource.setUsername("prashant");
        driverManagerDataSource.setPassword("1111");
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull("org.postgresql.Driver"));
        return driverManagerDataSource;
    }
}