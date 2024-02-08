package com.example.assessment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "events")
public class EventCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "venue")
    private String venue;

    @Column(name = "ticket")
    private int tickets;
}
