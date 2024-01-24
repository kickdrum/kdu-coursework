package com.example.sbhandson1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String company;
    private int year;
    private String color;
    private int price;
}
