package com.example.demo.config;

import com.example.demo.logging.Logging;
import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Configuration class responsible for initializing and running the application.
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class Application {

    private final VehicleService vehicleService;

    @Autowired
    public Application(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void printMostExpensiveVehicleDetails() {
        Vehicle mostExpensiveVehicle = vehicleService.findMostExpensiveVehicle();
        Logging.getmsg().info("Most Expensive Vehicle Details: {}", mostExpensiveVehicle);
    }

    public static void main(String[] args) {
        // Create and configure the Spring context using AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the beans from the context
        VehicleService vehicleService = context.getBean(VehicleService.class);

        // Generate the vehicles using VehicleService
        vehicleService.generateVehicleList();

        // Create the application instance and pass dependencies
        Application application = new Application(vehicleService);

        // Initialize the application
        application.init();
    }

    private void init() {
        Logging.getmsg().info("Application initialized.");
    }
}
