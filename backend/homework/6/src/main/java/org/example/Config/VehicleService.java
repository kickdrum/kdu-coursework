package org.example.Config;
import org.example.Bean.Speaker;
import org.example.Bean.Tyre;
import org.example.Bean.Vehicle;
import static org.example.Main.slf4jLogger;


import javax.annotation.PostConstruct;
import java.util.*;

public class VehicleService {
    
    ArrayList<Vehicle>vehicles;
    @PostConstruct
    public void createVehicles(){
        vehicles=new ArrayList<>();
    }

    public void addToVehicleList( Speaker speaker, Tyre tyre){
        Vehicle newVehicle = new Vehicle(speaker, tyre);
        Double cost = VehiclePrice(newVehicle);
        newVehicle.setPrice(cost);
        vehicles.add(newVehicle);
    }
    public Double VehiclePrice(Vehicle vehicle) {
        return vehicle.getSpeaker().getPrice() + vehicle.getTyre().getPrice() + generateVehiclePrice();
    }
    private double generateVehiclePrice() {
        return 10000.0;
    }

    public void printMostExpensiveVehicleDetails() {
        System.out.println("Most Expensive Vehicle Details:");

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
    private void printVehicleDetails(Vehicle vehicle) {

        slf4jLogger.info("Brand of Speaker: " + vehicle.getSpeaker().getBrand());
        slf4jLogger.info("Price of Speaker: " + vehicle.getSpeaker().getPrice());
        slf4jLogger.info("Brand of Tyre: " + vehicle.getTyre().getBrand());
        slf4jLogger.info("Price of Tyre: " + vehicle.getTyre().getPrice());
        slf4jLogger.info("Total Price of Vehicle: " + vehicle.getPrice());
    }


}
