package com.example.prashantjdbc.controller;

import com.example.prashantjdbc.dto.*;
import com.example.prashantjdbc.service.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Data
@RequiredArgsConstructor
public class TenantController {

    @Autowired
    ShiftService shiftService;
    @Autowired
    ShiftTypeService shiftTypeService;
    @Autowired
    UserService userService;
    @Autowired
    AllEntitiesService allEntitiesService;
    @Autowired
    ShiftUserService shiftUserService;

    @PostMapping("/saveShift")
    public ResponseEntity<String> saveShift(@RequestBody ShiftDto shiftDto) {
        try {
            shiftService.saveShift(shiftDto);
            return ResponseEntity.ok("Shift saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Shift");
        }
    }

    @GetMapping("getShift/{id}")
    public ResponseEntity<String> getByTenant(@JsonDeserialize UUID tenantID) {
        try {
            tenantID=UUID.fromString("7c2b02d2-2a12-4a3b-af04-1dcf1ee62898");
            List<ShiftDto> shiftDTO = shiftService.getShift(tenantID);
            if (shiftDTO!=null) {
                return ResponseEntity.ok(shiftDTO.toString());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get shift");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAllEntities(@RequestBody AllEntitiesDTO allEntitiesDTO) {
        try {
            allEntitiesService.saveAllEntities(allEntitiesDTO);
            return ResponseEntity.ok("All entities saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving entities");
        }
    }

    @PostMapping("/saveShiftType")
    public ResponseEntity<String> saveShiftType(@RequestBody ShiftTypeDto shiftTypeDto) {
        try {
            shiftTypeService.saveShiftType(shiftTypeDto);
            return ResponseEntity.ok("ShiftType saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving ShiftType");
        }
    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        try {
            userService.saveUser(userDto);
            return ResponseEntity.ok("User saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving User");
        }
    }

    @PostMapping("/saveShiftUser")
    public ResponseEntity<String> saveShiftUser(@RequestBody ShiftUserDto shiftUserDto) {
        try {
            shiftUserService.saveShiftUser(shiftUserDto);
            return ResponseEntity.ok("ShiftUser saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving ShiftUser");
        }
    }

}
