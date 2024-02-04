package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    // other fields, getters, setters, constructors
}
