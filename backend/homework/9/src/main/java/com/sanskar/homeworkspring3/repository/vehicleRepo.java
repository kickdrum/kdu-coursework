package com.sanskar.homeworkspring3.repository;

import com.sanskar.homeworkspring3.model.vehicle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @vehicleRepo contains the vehicle repository
 * find's the most expensive and least based on query parameters
 */
@Data
public class vehicleRepo{

    private List<vehicle> vehicl = new ArrayList<>();

    public void save(vehicle vehicls){
        this.vehicl.add(vehicls);
    }

    public vehicle findById(int id){
        return vehicl.get(id);
    }

    public void updateVehicle(int id, vehicle vehicles){
        vehicl.get(id).setName(vehicles.getName());
        vehicl.get(id).setPrice(vehicles.getPrice());
    }

    public void delete(int id){
        vehicl.remove(id);
    }

    public vehicle mostExpensive(){
        vehicle mostexpensivevehicle = vehicl.get(0);
        for(int i = 1; i < vehicl.size(); i++){
            vehicle currentVehicle = vehicl.get(i);
            if(currentVehicle.getPrice() > mostexpensivevehicle.getPrice()){
                mostexpensivevehicle = currentVehicle;
            }
        }
        return mostexpensivevehicle;
    }

    public vehicle leastExpensive(){
        vehicle leastexpensivevehicle = vehicl.get(0);
        for(int i = 1; i < vehicl.size(); i++){
            vehicle currentVehicle = vehicl.get(i);
            if(currentVehicle.getPrice() > leastexpensivevehicle.getPrice()){
                leastexpensivevehicle = currentVehicle;
            }
        }
        return leastexpensivevehicle;
    }

    public List<vehicle> getVehicles() {
        return vehicl;
    }
}