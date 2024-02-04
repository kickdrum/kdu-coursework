package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
    private LocalDateTime manufactureDateTime;
    private String manufactureFactoryPlace;

    @OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Device device;

    // other fields, getters, setters, constructors
}
