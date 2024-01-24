package com.example.sbhandson1.controller;

import com.example.sbhandson1.DTO.VehicleRequestDto;
import com.example.sbhandson1.DTO.VehicleResponseDto;
import com.example.sbhandson1.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public VehicleResponseDto createVehicle(@RequestBody VehicleRequestDto vehicleDto) {
        return vehicleService.createVehicle(vehicleDto);
    }

    @GetMapping("/vehicle/{id}")
    public VehicleResponseDto getVehicle(@PathVariable Integer id) {
        return vehicleService.getVehicle(id);
    }

    @PutMapping("/vehicle/{id}")
    public VehicleResponseDto updateVehicle(@PathVariable Integer id, @RequestBody VehicleRequestDto vehicleRequestDto) {
        return vehicleService.updateVehicle(id, vehicleRequestDto);
    }

    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        return vehicleService.deleteVehicle(id).getMessage();
    }

    @GetMapping("/expensive-vehicles")
    public VehicleResponseDto getMostOrLeastExpensiveVehicle(@RequestParam(required = false) String sortDirection) {
        return vehicleService.getMostOrLeastExpensiveVehicle(sortDirection);
    }
}
