package com.example.prashantjdbc.service;

import com.example.prashantjdbc.dto.ShiftDto;
import com.example.prashantjdbc.dao.ShiftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShiftService {

    private final ShiftDao shiftDao;


    @Autowired
    public ShiftService(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }

    public void saveShift(ShiftDto shiftDto) {
        shiftDao.saveShift(shiftDto);
    }

    public List<ShiftDto> getShift(UUID tenantID)
    {
        return  shiftDao.getShift(tenantID);
    }

}
