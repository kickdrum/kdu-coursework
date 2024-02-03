package com.example.springbootapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;
    int age;

    String password;

    String phoneNo;
}

