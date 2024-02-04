package com.example.prashantminiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class AuthResponse {

    String message;
    String token;
    HttpStatus httpStatus;
}