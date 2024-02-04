package com.example.prashantminiproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"users","rooms"})
@Table(name = "house")
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long houseId;
    private String name;
    private String address;
    private Long ownerId;

    @ManyToMany(mappedBy = "houses", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "house")
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

    public void addUser(User users) {

    }
}

