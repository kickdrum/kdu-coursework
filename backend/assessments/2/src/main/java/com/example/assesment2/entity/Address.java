package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
