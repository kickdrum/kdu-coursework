package com.example.prashantminiproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long usersId;

    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;

    @ManyToMany(mappedBy = "users")
    private List<House> houses;
}


