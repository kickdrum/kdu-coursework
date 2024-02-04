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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;

    @ManyToMany
    private List<House> houses;

    // other fields, getters, setters, constructors
}

//@Entity
//public class Users {
//    @Id
//    private String userId;
//    private String name;
//    private String email;
//    private String password;
//    private String role;
//}
