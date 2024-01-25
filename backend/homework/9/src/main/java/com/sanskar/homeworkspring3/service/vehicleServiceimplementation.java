package com.sanskar.homeworkspring3.service;

import com.sanskar.homeworkspring3.repository.*;
import com.sanskar.homeworkspring3.model.*;
import com.sanskar.homeworkspring3.mapper.*;
import com.sanskar.homeworkspring3.vehicledto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class VehicleServiceImplementation implements VehicleService{
    private final vehicleRepo inventoryStore = new vehicleRepo();
    public vehicledto createVehicle(vehicledto vehicleDto){
        vehicle vehicle= vehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.save(vehicle);
        return vehicleDto;
    }


    public vehicle getVehicleById(int id){
        vehicle vehicle=inventoryStore.findById(id);
        return vehicle;
    }
    public List<vehicle> getAllVehicles(){
        List<vehicle> vehicles=inventoryStore.getVehicles();
        return vehicles;
    }
    public void updateVehicle(int id, vehicledto vehicleDto){
        vehicle vehicle= vehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.updateVehicle(id, vehicle);
    }
    public void deleteVehicle(int id){
        inventoryStore.delete(id);
    }
    public vehicle mostExpensive(){
        return inventoryStore.mostExpensive();
    }
    public vehicle leastExpensive(){
        return inventoryStore.leastExpensive();
    }
}