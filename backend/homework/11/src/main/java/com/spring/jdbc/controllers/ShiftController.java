package com.spring.jdbc.controllers;

import com.spring.jdbc.entities.Shift;
import com.spring.jdbc.repository.shift.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftRepository shiftRepository;

    @GetMapping
    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Shift> createShift(@RequestBody Shift shift) {
        shiftRepository.save(shift);
        return new ResponseEntity<>(shift, HttpStatus.CREATED);
    }
}
