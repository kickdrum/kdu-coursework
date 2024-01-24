package com.example.springboot3.repository;

import com.example.springboot3.model.Vehicle;
import lombok.Data;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static com.example.springboot3.Springboot3Application.slf4jLogger;

@Data
public class InventoryStore {
    private List<Vehicle> vehicles=new ArrayList<>();

    public void save(Vehicle vehicle){
        this.vehicles.add(vehicle);
        slf4jLogger.info("Vehicle added");
    }
    public Vehicle findById(int id){
        slf4jLogger.info("Id found!");
        return vehicles.get(id);

    }
    public void updateVehicle(int id, Vehicle vehicle){
        vehicles.get(id).setName(vehicle.getName());
        vehicles.get(id).setPrice(vehicle.getPrice());
        slf4jLogger.info("Vehicle updated!");


    }
    public void delete(int id){
        vehicles.remove(id);
        slf4jLogger.info("Vehicle Deleted");

    }
    public Vehicle mostExpensive(){
        Vehicle mostExpensiveVehicle = vehicles.get(0); // Assume the first vehicle is the most expensive initially

        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle currentVehicle = vehicles.get(i);
            if (currentVehicle.getPrice() > mostExpensiveVehicle.getPrice()) {
                mostExpensiveVehicle = currentVehicle;
            }
        }
        return mostExpensiveVehicle;
    }

    public Vehicle leastExpensive(){
        Vehicle leastExpensiveVehicle = vehicles.get(0); // Assume the first vehicle is the least expensive initially

        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle currentVehicle = vehicles.get(i);
            if (currentVehicle.getPrice() < leastExpensiveVehicle.getPrice()) {
                leastExpensiveVehicle = currentVehicle;
            }
        }
        return leastExpensiveVehicle;
    }
}
