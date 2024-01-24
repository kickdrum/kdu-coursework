package com.example.springboot3.service;

import com.example.springboot3.dto.VehicleDto;
import com.example.springboot3.mapper.VehicleMapper;
import com.example.springboot3.model.Vehicle;
import com.example.springboot3.repository.InventoryStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    private InventoryStore inventoryStore=new InventoryStore();

    public void createVehicle(VehicleDto vehicleDto){
        Vehicle vehicle= VehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.save(vehicle);
    }
    public Vehicle getVehicleById(int id){
        Vehicle vehicle=inventoryStore.findById(id);
        return vehicle;
    }
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles=inventoryStore.getVehicles();
        return vehicles;
    }
    public void updateVehicle(int id, VehicleDto vehicleDto){
        Vehicle vehicle= VehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.updateVehicle(id, vehicle);
    }
    public void deleteVehicle(int id){
        inventoryStore.delete(id);
    }
    public Vehicle mostExpensive(){
        return inventoryStore.mostExpensive();
    }
    public Vehicle leastExpensive(){
        return inventoryStore.leastExpensive();
    }
}
