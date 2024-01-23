package org.example.Inventory;
import org.example.Vehicle.Entity.Speaker;
import org.example.Vehicle.Entity.Tyre;
import org.example.Vehicle.Entity.Vehicle;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
public class InventoryStore {
    ArrayList<Vehicle> vehicles;
    @PostConstruct
    public void createVehicles(){
        vehicles=new ArrayList<>();
    }

    public void addToVehicleList(Speaker speaker, Tyre tyre){
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

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }
}