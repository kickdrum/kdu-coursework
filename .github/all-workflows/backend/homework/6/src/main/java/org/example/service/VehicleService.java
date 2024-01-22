package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.Constants;
import org.example.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;

    /**
     * addVehicles function adds all the vehicles to the list
     */
    @PostConstruct
    public void addVehicles(){
        Vehicle vehicle1 = new Vehicle(speakerService.speaker1(),tyreService.tyre1(), Constants.VEHICLE_PRICE + speakerService.speaker1().getSpeakerPrice() + tyreService.tyre1().getTyrePrice()*Constants.NUMBER_OF_TYRES);
        vehicles.add(vehicle1);
        Vehicle vehicle2 = new Vehicle(speakerService.speaker1(),tyreService.tyre2(), Constants.VEHICLE_PRICE + speakerService.speaker1().getSpeakerPrice() + tyreService.tyre2().getTyrePrice()*Constants.NUMBER_OF_TYRES);
        vehicles.add(vehicle2);
        Vehicle vehicle3 = new Vehicle(speakerService.speaker2(),tyreService.tyre1(), Constants.VEHICLE_PRICE + speakerService.speaker2().getSpeakerPrice() + tyreService.tyre1().getTyrePrice()*Constants.NUMBER_OF_TYRES);
        vehicles.add(vehicle3);
        Vehicle vehicle4 = new Vehicle(speakerService.speaker2(),tyreService.tyre2(), Constants.VEHICLE_PRICE + speakerService.speaker2().getSpeakerPrice() + tyreService.tyre2().getTyrePrice()*Constants.NUMBER_OF_TYRES);
        vehicles.add(vehicle4);
    }

    /**
     * findMostExpensiveVehicle function iterates through the list and finds the most expensive vehicle
     * @return
     */
    public Vehicle findMostExpensiveVehicle() {
        return vehicles.stream()
                .reduce((v1, v2) -> v1.getPrice() > v2.getPrice() ? v1 : v2)
                .orElse(null);
    }
}
