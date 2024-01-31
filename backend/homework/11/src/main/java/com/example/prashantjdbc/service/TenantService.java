package com.example.prashantjdbc.service;

import com.example.prashantjdbc.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TenantService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @PostMapping("/save")
//    public static ResponseEntity<String> saveTenant(@RequestBody TenantDto tenantDto) {
//        try {
//            TenantService.saveTenant(tenantDto);
//            return ResponseEntity.ok("Tenant saved successfully");
//        } catch (DataAccessException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving tenant: " + e.getMessage());
//        }
//    }
    public void saveShiftType(ShiftTypeDto shiftTypeDto) {
        String sql = "INSERT INTO shift_types (id, uq_name, description, active, created_by, updated_by, created_at, updated_at, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                shiftTypeDto.getId(),
                shiftTypeDto.getUqName(),
                shiftTypeDto.getDescription(),
                shiftTypeDto.isActive(),
                shiftTypeDto.getCreatedBy(),
                shiftTypeDto.getUpdatedBy(),
                shiftTypeDto.getCreatedAt(),
                shiftTypeDto.getUpdatedAt(),
                shiftTypeDto.getTimeZone(),
                shiftTypeDto.getTenantId());
    }

    public void saveShift(ShiftDto shiftDto) {
        String sql = "INSERT INTO shifts (id, shift_type_id, name, date_start, date_end, time_start, time_end, created_by, updated_by, created_at, updated_at, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                shiftDto.getId(),
                shiftDto.getShiftTypeId(),
                shiftDto.getName(),
                shiftDto.getDateStart(),
                shiftDto.getDateEnd(),
                shiftDto.getTimeStart(),
                shiftDto.getTimeEnd(),
                shiftDto.getCreatedBy(),
                shiftDto.getUpdatedBy(),
                shiftDto.getCreatedAt(),
                shiftDto.getUpdatedAt(),
                shiftDto.getTimeZone(),
                shiftDto.getTenantId());
    }

    public void saveUser(UserDto userDto) {
        String sql = "INSERT INTO users (id, username, loggedin, time_zone, created_by, updated_by, created_at, updated_at, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                userDto.getId(),
                userDto.getUsername(),
                userDto.getLoggedIn(),
                userDto.getTimeZone(),
                userDto.getCreatedBy(),
                userDto.getUpdatedBy(),
                userDto.getCreatedAt(),
                userDto.getUpdatedAt(),
                userDto.getTenantId());
    }

    public void saveShiftUser(ShiftUserDto shiftUserDto) {
        String sql = "INSERT INTO shift_users (id, shift_id, user_id, created_by, updated_by, created_at, updated_at, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                shiftUserDto.getId(),
                shiftUserDto.getShiftId(),
                shiftUserDto.getUserId(),
                shiftUserDto.getCreatedBy(),
                shiftUserDto.getUpdatedBy(),
                shiftUserDto.getCreatedAt(),
                shiftUserDto.getUpdatedAt(),
                shiftUserDto.getTenantId());
    }


}