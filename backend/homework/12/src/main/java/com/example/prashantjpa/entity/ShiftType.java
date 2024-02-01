package com.example.prashantjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "shift_type")
@Data
@AllArgsConstructor

public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String uniqueName;

    @Column(name = "tenant_id", nullable = false)
    private long tenantId;


}