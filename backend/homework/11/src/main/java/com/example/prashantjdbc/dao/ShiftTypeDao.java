package com.example.prashantjdbc.dao;

import com.example.prashantjdbc.dto.ShiftTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftTypeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void saveShiftType(ShiftTypeDto shiftTypeDTO) {
        String sql = "INSERT INTO public.shift_types(id, uq_name, description, active, created_by, updated_by, created_at, updated_at, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                generateUUID(),
                shiftTypeDTO.getUqName(),
                shiftTypeDTO.getDescription(),
                shiftTypeDTO.isActive(),
                shiftTypeDTO.getCreatedBy(),
                shiftTypeDTO.getUpdatedBy(),
                shiftTypeDTO.getCreatedAt(),
                shiftTypeDTO.getUpdatedAt(),
                shiftTypeDTO.getTimeZone(),
                shiftTypeDTO.getTenantId());
    }

}
