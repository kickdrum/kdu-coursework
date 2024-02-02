package com.example.assesment2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    //name description price stockQuantity
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;
}
