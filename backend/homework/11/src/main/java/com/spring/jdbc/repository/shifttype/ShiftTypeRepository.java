package com.spring.jdbc.repository.shifttype;

import com.spring.jdbc.entities.ShiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShiftTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ShiftType> findAll() {
        return jdbcTemplate.query("SELECT * FROM shift_types", BeanPropertyRowMapper.newInstance(ShiftType.class));
    }

    public int save(ShiftType shiftType) {
        return jdbcTemplate.update("INSERT INTO shift_types (id, name, description, active, createdAt, updatedAt, timeZone, tenantId) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                shiftType.getId(), shiftType.getName(), shiftType.getDescription(), shiftType.isActive(),
                shiftType.getCreatedAt(), shiftType.getUpdatedAt(), shiftType.getTimeZone(), shiftType.getTenantId());
    }
}
