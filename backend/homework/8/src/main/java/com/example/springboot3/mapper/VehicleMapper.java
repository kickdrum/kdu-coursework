package com.example.springboot3.mapper;

import com.example.springboot3.dto.VehicleDto;
import com.example.springboot3.model.Vehicle;

public class VehicleMapper {

    // Convert User JPA Entity into VehicleDto
    public static VehicleDto mapToVehicleBto(Vehicle vehicle){
        VehicleDto vehicleDto= new VehicleDto(vehicle.getName(),vehicle.getPrice());
        return vehicleDto;
    }
    // Convert VehicleDto into User JPA Entity
    public static Vehicle mapToVehicle(VehicleDto vehicleDto){
        Vehicle vehicle=new Vehicle(vehicleDto.getName(), vehicleDto.getPrice());
        return vehicle;
    }
}
