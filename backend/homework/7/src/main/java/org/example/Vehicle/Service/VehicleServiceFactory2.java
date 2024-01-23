package org.example.Vehicle.Service;

import org.example.Config.ProjectConfig;
import org.example.Inventory.InventoryStore;
import org.example.Vehicle.Entity.Speaker;
import org.example.Vehicle.Entity.Tyre;
import org.example.Vehicle.Entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.example.Main.slf4jLogger;

@Service
public class VehicleServiceFactory2 {
    private InventoryStore invStore;
    private static AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

    @Autowired
    public VehicleServiceFactory2(@Qualifier("factory2") InventoryStore invStore){
        this.invStore=invStore;
    }
    public void generateVehicle(String speakerType, String tyreType){
        Speaker speaker=(Speaker) context.getBean(speakerType, Speaker.class);
        Tyre tyre=(Tyre) context.getBean(tyreType, Tyre.class);
        tyre.setPrice(tyre.getPrice()*1.25);
        invStore.addToVehicleList(speaker, tyre);
    }
    public void getMaximumPriceVehicle(){
        ArrayList<Vehicle> vehicles=invStore.getVehicles();
        System.out.println("Most Expensive Vehicle for factory 2 Details:");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        Vehicle mostExpensiveVehicle = vehicles.get(0); // Assume the first vehicle is the most expensive initially

        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle currentVehicle = vehicles.get(i);
            if (currentVehicle.getPrice() > mostExpensiveVehicle.getPrice()) {
                mostExpensiveVehicle = currentVehicle;
            }
        }

        // Print details of the most expensive vehicle
        printVehicleDetails(mostExpensiveVehicle);
    }
    public void getMinimumPriceVehicle() {
        ArrayList<Vehicle> vehicles = invStore.getVehicles();
        System.out.println("Least Expensive Vehicle for factory 2 Details:");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        Vehicle leastExpensiveVehicle = vehicles.get(0); // Assume the first vehicle is the least expensive initially

        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle currentVehicle = vehicles.get(i);
            if (currentVehicle.getPrice() < leastExpensiveVehicle.getPrice()) {
                leastExpensiveVehicle = currentVehicle;
            }
        }

        // Print details of the least expensive vehicle
        printVehicleDetails(leastExpensiveVehicle);
    }
    private void printVehicleDetails(Vehicle vehicle) {

        slf4jLogger.info("Brand of Speaker: " + vehicle.getSpeaker().getBrand());
        slf4jLogger.info("Price of Speaker: " + vehicle.getSpeaker().getPrice());
        slf4jLogger.info("Brand of Tyre: " + vehicle.getTyre().getBrand());
        slf4jLogger.info("Price of Tyre: " + vehicle.getTyre().getPrice());
        slf4jLogger.info("Total Price of Vehicle: " + vehicle.getPrice());
    }

}


//setter tester