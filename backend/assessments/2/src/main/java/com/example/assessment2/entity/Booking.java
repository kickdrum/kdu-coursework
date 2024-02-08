package com.example.assessment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class Booking{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;

    @Column(name = "event")
    private EventCatalog eventCatalog;

}
