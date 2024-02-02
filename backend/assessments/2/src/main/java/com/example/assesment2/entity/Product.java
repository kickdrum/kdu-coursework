package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "product_id"
    )
    private Long productId;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;

}
