package com.example.prashantjpa.controller;

import com.example.prashantjpa.entity.Shift;
import com.example.prashantjpa.service.ShiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

@Slf4j
public class ShiftController {
    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/saveShift")
    public Shift saveShift(@RequestBody Shift shift) {
        log.info("Shift Saved");
        return shiftService.saveShift(shift);
    }
    @GetMapping("/top3users")
    public ResponseEntity<List<Shift>> TopShifts() {
        LocalDate startDate = LocalDate.of(2024, 1, 3);
        LocalDate endDate = LocalDate.of(2024, 1, 31);
        List<Shift> top3Shifts = shiftService.topShifts(startDate, endDate);
        return ResponseEntity.ok(top3Shifts);
    }
}