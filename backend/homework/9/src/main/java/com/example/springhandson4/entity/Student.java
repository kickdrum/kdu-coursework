package com.example.springhandson4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private int age;
    private Subject subject;
}
