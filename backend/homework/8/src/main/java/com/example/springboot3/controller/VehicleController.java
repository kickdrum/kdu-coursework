package com.example.springboot3.controller;

import com.example.springboot3.dto.VehicleDto;
import com.example.springboot3.model.Vehicle;
import com.example.springboot3.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleController {
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicle){
        vehicleService.createVehicle(vehicle);
        String created="The vehicle is added ";
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //GET : /vehicle/2
    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("vehicle/allVehicles")
    public List<Vehicle> getAllVehicles(){
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
