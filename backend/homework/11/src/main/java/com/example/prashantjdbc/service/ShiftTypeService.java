package com.example.prashantjdbc.service;

import com.example.prashantjdbc.dto.ShiftTypeDto;
import com.example.prashantjdbc.dao.ShiftTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShiftTypeService {

    private final ShiftTypeDao shiftTypeDao;

    @Autowired
    public ShiftTypeService(ShiftTypeDao shiftTypeDao) {
        this.shiftTypeDao = shiftTypeDao;
    }

    public void saveShiftType(ShiftTypeDto shiftTypeDto) {
        shiftTypeDao.saveShiftType(shiftTypeDto);
    }

}
