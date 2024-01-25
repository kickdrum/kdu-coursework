package com.example.springhandson4.dto;

import com.example.springhandson4.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDTO {
    private int studentID;
    private String firstName;
    private String lastName;
    private int age;
    private Subject subject;
}
