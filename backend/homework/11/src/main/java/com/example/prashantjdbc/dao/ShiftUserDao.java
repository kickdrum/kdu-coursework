package com.example.prashantjdbc.dao;

import com.example.prashantjdbc.dto.ShiftUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftUserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void saveShiftUser(ShiftUserDto shiftUserDTO) {
        String sql = "INSERT INTO public.shift_users(id, shift_id, user_id, created_by, updated_by, created_at, updated_at, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                generateUUID(),
                shiftUserDTO.getShiftId(),
                shiftUserDTO.getUserId(),
                shiftUserDTO.getCreatedBy(),
                shiftUserDTO.getUpdatedBy(),
                shiftUserDTO.getCreatedAt(),
                shiftUserDTO.getUpdatedAt(),
                shiftUserDTO.getTenantId());
    }
}
