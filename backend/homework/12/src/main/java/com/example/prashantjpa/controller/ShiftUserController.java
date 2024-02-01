package com.example.prashantjpa.controller;

import com.example.prashantjpa.entity.ShiftUser;
import com.example.prashantjpa.exception.UserNotFoundException;
import com.example.prashantjpa.service.ShiftUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@Slf4j
@RequestMapping("/api/shift-users")
public class ShiftUserController {

    private final ShiftUserService shiftUserService;

    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }

    @PostMapping("/saveShiftUser")
    public ShiftUser createShiftUser(@RequestBody ShiftUser shiftUser) {
        log.info("Shift User Saved");
        return shiftUserService.saveShiftUser(shiftUser);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID userId)
            throws UserNotFoundException {
        try {
            shiftUserService.deleteShiftUser(userId);
            return ResponseEntity.ok("Deleted Shift User with ID " + userId);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}