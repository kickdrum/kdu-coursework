package com.example.prashantjpa.service;
import com.example.prashantjpa.entity.ShiftUser;
import com.example.prashantjpa.repository.ShiftUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShiftUserService {

    private final ShiftUserRepo shiftUserRepo;

    @Autowired
    public ShiftUserService(ShiftUserRepo shiftUserRepo) {
        this.shiftUserRepo = shiftUserRepo;
    }
    public ShiftUser saveShiftUser(ShiftUser shiftUser) {
        return shiftUserRepo.save(shiftUser);
    }

    public void deleteShiftUser(UUID userId) {
        shiftUserRepo.deleteByUser_Id(userId);
    }
}