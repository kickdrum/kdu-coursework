package com.example.prashantjpa.service;

import com.example.prashantjpa.entity.ShiftType;
import com.example.prashantjpa.repository.ShiftTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftTypeService {

    private final ShiftTypeRepo shiftTypeRepo;

    @Autowired
    public ShiftTypeService(ShiftTypeRepo shiftTypeRepo) {
        this.shiftTypeRepo = shiftTypeRepo;
    }

    public ShiftType saveShiftType(ShiftType shiftType) {
        return shiftTypeRepo.save(shiftType);
    }

    public List<ShiftType> getAllShiftTypes() {
        return shiftTypeRepo.findAll();
    }
}