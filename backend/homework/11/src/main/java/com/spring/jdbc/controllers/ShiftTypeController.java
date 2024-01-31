package com.spring.jdbc.controllers;

import com.spring.jdbc.entities.ShiftType;
import com.spring.jdbc.repository.shifttype.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shift-types")
public class ShiftTypeController {

    @Autowired
    private ShiftTypeRepository shiftTypeRepository;

    @GetMapping
    public List<ShiftType> getAllShiftTypes() {
        return shiftTypeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ShiftType> createShiftType(@RequestBody ShiftType shiftType) {
        shiftTypeRepository.save(shiftType);
        return new ResponseEntity<>(shiftType, HttpStatus.CREATED);
    }
}
