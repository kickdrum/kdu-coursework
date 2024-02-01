package com.example.prashantjpa.service;

import com.example.prashantjpa.entity.Shift;
import com.example.prashantjpa.repository.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShiftService {
    private final ShiftRepo shiftRepo;

    @Autowired
    public ShiftService(ShiftRepo shiftRepo) {
        this.shiftRepo = shiftRepo;
    }

    public Shift saveShift(Shift shift) {
        return shiftRepo.save(shift);
    }

    public List<Shift> getAllShifts() {
        return shiftRepo.findAll();
    }

    public List<Shift> topShifts(LocalDate startDate, LocalDate endDate) {
        return shiftRepo.findTop3(startDate, endDate);
    }
}
