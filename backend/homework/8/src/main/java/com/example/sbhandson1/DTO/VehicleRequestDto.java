package com.example.sbhandson1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleRequestDto {
    private int id;
    private String company;
    private int year;
    private String color;
    private int price;
}
