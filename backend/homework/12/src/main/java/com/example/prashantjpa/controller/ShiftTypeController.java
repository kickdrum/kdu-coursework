package com.example.prashantjpa.controller;

import com.example.prashantjpa.entity.ShiftType;
import com.example.prashantjpa.service.ShiftTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shift-types")
@Slf4j
public class ShiftTypeController {
    private final ShiftTypeService shiftTypeService;

    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @PostMapping
    public ShiftType saveShiftType(@RequestBody ShiftType shiftType) {
        log.info("ShiftType saved");
        return shiftTypeService.saveShiftType(shiftType);
    }

}