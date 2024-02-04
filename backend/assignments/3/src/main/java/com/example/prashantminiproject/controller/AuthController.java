package com.example.prashantminiproject.controller;

import com.example.prashantminiproject.dto.UserDto;
import com.example.prashantminiproject.dto.ResponseUser;
import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUser> registerUser(@RequestBody UserDto userDto) {
        User user = userService.registerUser(userDto);
        String token = user.getToken();
        return new ResponseEntity<>(new ResponseUser("User registered", token), HttpStatus.OK);
    }
}