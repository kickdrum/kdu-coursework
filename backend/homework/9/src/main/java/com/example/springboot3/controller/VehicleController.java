package com.example.springboot3.controller;

import com.example.springboot3.dto.VehicleDto;
import com.example.springboot3.exception.custom.BadRequestException;
import com.example.springboot3.exception.custom.CustomNullException;
import com.example.springboot3.exception.custom.ResourceNotFoundException;
import com.example.springboot3.model.Vehicle;
import com.example.springboot3.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springboot3.Springboot3Application.slf4jLogger;

@RestController
@AllArgsConstructor
public class VehicleController {
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicle){
        if (vehicle == null || vehicle.getName() == null || vehicle.getPrice() == null) {
            throw new BadRequestException("Bad Request");
        }
        vehicleService.createVehicle(vehicle);
        String created="The vehicle is added ";
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //GET : /vehicle/2
    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        Vehicle vehicle=null;
        try{
            vehicle=vehicleService.getVehicleById(id);
            if(vehicle.getName()==null){
                throw new CustomNullException("Null value is found for id- "+id+" in storage");
            }
            else if(vehicle.getPrice()==null){
                throw new CustomNullException("Null value is found for id- "+id+" in storage");
            }
        }
        catch (IndexOutOfBoundsException ex){
            throw new ResourceNotFoundException("No data found for id- "+id+" in storage");
        }
        return vehicleService.getVehicleById(id);
    }
    @GetMapping("vehicle/allVehicles")
    public List<Vehicle> getAllVehicles(){
        slf4jLogger.debug("All vehicles are displayed");
        List<Vehicle> vehicles=vehicleService.getAllVehicles();
        return vehicles;
    }

    // PUT: /vehicle/2
    @PutMapping("/vehicle/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody VehicleDto vehicle) {
        vehicleService.updateVehicle(id, vehicle);
        String updated="The vehicle is Updated";
        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    // DELETE: /vehicle/2
    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        String deleted="The vehicle is deleted";
        return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }

    @GetMapping("/vehicle/mostExpensive")
    public Vehicle mostExpensive(){
        return vehicleService.mostExpensive();
    }
    @GetMapping("/vehicle/leastExpensive")
    public Vehicle leastExpensive(){
        return vehicleService.leastExpensive();
    }


}
