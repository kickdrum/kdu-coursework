package org.example;

import org.example.Config.ProjectConfig;
import org.example.Vehicle.Service.VehicleServiceFactory1;
import org.example.Vehicle.Service.VehicleServiceFactory2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServiceFactory1 v1= context.getBean(VehicleServiceFactory1.class);
        VehicleServiceFactory2 v2= context.getBean(VehicleServiceFactory2.class);

        v1.generateVehicle("Sony", "MRF");
        v1.generateVehicle("Bose", "Bridgestone");
        v1.generateVehicle("Bose", "MRF");
        v1.generateVehicle("Sony", "Bridgestone");
        v1.getMaximumPriceVehicle();
        v1.getMinimumPriceVehicle();
        System.out.println();

        v2.generateVehicle("Bose", "MRF");
        v2.generateVehicle("Sony", "Bridgestone");
        v2.generateVehicle("Bose", "MRF");
        v2.generateVehicle("Sony", "Bridgestone");
        v2.getMaximumPriceVehicle();
        v2.getMinimumPriceVehicle();


    }
}