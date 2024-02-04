package com.example.prashantminiproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "kickston_id")
    private String kickstonId;

    private String deviceUsername;
    private String devicePassword;
    private LocalDateTime manufactureDateTime;
    private String manufactureFactoryPlace;
}
