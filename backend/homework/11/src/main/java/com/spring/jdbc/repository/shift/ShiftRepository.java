package com.spring.jdbc.repository.shift;

import com.spring.jdbc.entities.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShiftRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Shift> findAll() {
        return jdbcTemplate.query("SELECT * FROM shifts", BeanPropertyRowMapper.newInstance(Shift.class));
    }

    public int save(Shift shift) {
        return jdbcTemplate.update("INSERT INTO shifts (id, shiftTypeId, name, dateStart, dateEnd, timeStart, timeEnd, createdAt, updatedAt, timeZone, tenantId) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                shift.getId(), shift.getShiftTypeId(), shift.getName(), shift.getDateStart(), shift.getDateEnd(),
                shift.getTimeStart(), shift.getTimeEnd(), shift.getCreatedAt(), shift.getUpdatedAt(), shift.getTimeZone(), shift.getTenantId());
    }
}
