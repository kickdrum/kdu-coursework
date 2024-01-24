package com.example.sbhandson1.DTO;

import com.example.sbhandson1.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleResponseDto {
    private int id;
    private String company;
    private int year;
    private String color;
    private String message;
    private int price;
    public VehicleResponseDto(Vehicle vehicle, String message) {
        if (vehicle != null) {
            this.id = vehicle.getId();
            this.company = vehicle.getCompany();
            this.year = vehicle.getYear();
            this.color = vehicle.getColor();
            this.price = vehicle.getPrice();
        }
        this.message = message;
    }
}
