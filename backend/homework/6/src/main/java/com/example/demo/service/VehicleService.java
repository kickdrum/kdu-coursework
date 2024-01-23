package com.example.demo.service;

import com.example.demo.model.Speaker;
import com.example.demo.model.Tyre;
import com.example.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for managing Vehicle objects.
 */
@Service
public class VehicleService {

    private final TyreService tyreService;
    private final SpeakerService speakerService;
    private List<Vehicle> vehicles;

    @Autowired
    public VehicleService(TyreService tyreService, SpeakerService speakerService) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
    }

    @PostConstruct
    public void generateVehicleList() {
        vehicles = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Tyre tyre = tyreService.generateTyre();
            Speaker speaker = speakerService.generateSpeaker();
            Vehicle vehicle = new Vehicle(tyre, speaker);

            double totalPrice = calculateTotalPrice(vehicle);

            vehicle.setPrice(totalPrice);
            vehicles.add(vehicle);
        }
    }

    public Vehicle findMostExpensiveVehicle() {
        if (vehicles == null || vehicles.isEmpty()) {
            return null;
        }

        Vehicle mostExpensiveVehicle = vehicles.get(0);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > mostExpensiveVehicle.getPrice()) {
                mostExpensiveVehicle = vehicle;
            }
        }

        return mostExpensiveVehicle;
    }

    private double calculateTotalPrice(Vehicle vehicle) {
        // Calculate the total price of the vehicle
        // Sum the prices of tyre, speaker, and a random value
        return vehicle.getTyre().getPrice() + vehicle.getSpeaker().getPrice() + Math.random() * 1000;
    }
}
