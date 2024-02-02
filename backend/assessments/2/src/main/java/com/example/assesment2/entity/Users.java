package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String fullName;
    private String email;
    private String password;

//    @OneToMany(mappedBy = "addressId")
//    private List<Address> addresses;

    public Users(String admin1, String admin11, ArrayList<Object> objects) {

    }

    public String getRole() {
        return null;
    }
}
