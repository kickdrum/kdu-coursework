package com.example.prashantjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tenantId;

    private Instant CreatedAt;
    private Instant CreatedBy;
    private Instant UpdatedAt;
    private Instant UpdatedBy;

}
