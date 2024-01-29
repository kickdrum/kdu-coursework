package com.example.springbootapidemo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    String message;
    int statusCode;
}
