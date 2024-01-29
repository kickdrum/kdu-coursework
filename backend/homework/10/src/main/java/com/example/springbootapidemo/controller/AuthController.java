package com.example.springbootapidemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    /**
     * Login endpoint
     * @return: String
     */

    @GetMapping ("/auth/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("Logged in successfully!!!", HttpStatus.CREATED);
    }
}
