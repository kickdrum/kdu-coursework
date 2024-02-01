package com.example.Security.controller;

import com.example.Security.entity.User;
import com.example.Security.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userEntityService;

    public UserController(UserService userEntityService){
        this.userEntityService = userEntityService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<String> getAllUsers(){
        return new ResponseEntity<>(userEntityService.getAll().toString(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getUser(@RequestParam String name){
        return new ResponseEntity<>(userEntityService.getPersonUsername(name).toString(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User userEntity){
        userEntityService.addPerson(userEntity);
        return new ResponseEntity<>("Added user successfully", HttpStatus.OK);
    }
}
