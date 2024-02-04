package com.example.prashantminiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistrationRequest {
    private String name;
    private String username;
    private String password;
    private String role;
}