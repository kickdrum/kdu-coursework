package com.example.sbhandson1.repository;

import com.example.sbhandson1.DTO.VehicleResponseDto;
import com.example.sbhandson1.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Repository
public class VehicleInventory {
    private List<Vehicle> vehicleList;
    public VehicleInventory() {
        this.vehicleList = new ArrayList<>();
    }
    public VehicleResponseDto createVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return new VehicleResponseDto(vehicle, "Vehicle created successfully");
    }
    public Vehicle getVehicle(int id) {
        for(Vehicle vehicle: vehicleList) {
            if(vehicle.getId() == id) {
                return new Vehicle(vehicle.getId(), vehicle.getCompany(), vehicle.getYear(), vehicle.getColor(), vehicle.getPrice());
            }
        }
        return null;
    }
    public VehicleResponseDto updateVehicle(int id, Vehicle vehicle) {
        for(Vehicle oldVehicle: vehicleList) {
            if(oldVehicle.getId() == id) {
                vehicleList.remove(oldVehicle);
                vehicleList.add(vehicle);
                return new VehicleResponseDto(vehicle, "Vehicle updated successfully");
            }
        }
        return new VehicleResponseDto(null, "Vehicle not found");
    }

    public void deleteVehicle(int id) {
        for(Vehicle vehicle: vehicleList) {
            if(vehicle.getId() == id) {
                vehicleList.remove(vehicle);
                break;
            }
        }
    }

    public VehicleResponseDto getMostOrLeastExpensiveVehicle(String sortDirection) {
        Vehicle vehicle = null;
        if (sortDirection.equals("asc")) {
            vehicle = vehicleList.stream().max(Comparator.comparingInt(Vehicle::getPrice)).get();
        } else if (sortDirection.equals("desc")) {
            vehicle = vehicleList.stream().min(Comparator.comparingInt(Vehicle::getPrice)).get();
        }
        return new VehicleResponseDto(vehicle, "Vehicle found");
    }
}
