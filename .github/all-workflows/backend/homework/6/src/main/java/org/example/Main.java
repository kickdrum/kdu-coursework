package org.example;


import org.example.service.VehicleService;
import org.example.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        VehicleService vehicleservice=context.getBean(VehicleService.class);
        LoggerFile.logInfo("Price : " + vehicleservice.findMostExpensiveVehicle().getPrice());
    }
}