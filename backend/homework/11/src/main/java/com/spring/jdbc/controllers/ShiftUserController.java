package com.spring.jdbc.controllers;

import com.spring.jdbc.entities.ShiftUser;
import com.spring.jdbc.repository.shiftuser.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shift-users")
public class ShiftUserController {

    @Autowired
    private ShiftUserRepository shiftUserRepository;

    @GetMapping
    public List<ShiftUser> getAllShiftUsers() {
        return shiftUserRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ShiftUser> createShiftUser(@RequestBody ShiftUser shiftUser) {
        shiftUserRepository.save(shiftUser);
        return new ResponseEntity<>(shiftUser, HttpStatus.CREATED);
    }
}
