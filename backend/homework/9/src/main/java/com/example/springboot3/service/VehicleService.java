package com.example.springboot3.service;

import com.example.springboot3.dto.VehicleDto;
import com.example.springboot3.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    void createVehicle(VehicleDto vehicle);
    Vehicle getVehicleById(int id);

    List<Vehicle> getAllVehicles();
    void updateVehicle(int id, VehicleDto vehicle);
    void deleteVehicle(int id);
    Vehicle mostExpensive();
    Vehicle leastExpensive();
}
