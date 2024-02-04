package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;


    @OneToMany
    private List<Device> deviceList;

    // other fields, getters, setters, constructors
}
