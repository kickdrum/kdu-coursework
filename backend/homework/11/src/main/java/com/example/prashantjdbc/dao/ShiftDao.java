package com.example.prashantjdbc.dao;

import com.example.prashantjdbc.dto.ShiftDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
@Slf4j
public class ShiftDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShiftDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void saveShift(ShiftDto shiftDTO) {
        String sql = "INSERT INTO public.shifts(id, shift_type_id, name, date_start, date_end, time_start, time_end, created_by, updated_by, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                generateUUID(),
                shiftDTO.getShiftTypeId(),
                shiftDTO.getName(),
                shiftDTO.getDateStart(),
                shiftDTO.getDateEnd(),
                shiftDTO.getTimeStart(),
                shiftDTO.getTimeEnd(),
                shiftDTO.getCreatedBy(),
                shiftDTO.getUpdatedBy(),
                shiftDTO.getTimeZone(),
                shiftDTO.getTenantId());
    }

public List<ShiftDto> getShift(UUID tenantID) {
    try {
        String sqlStatement = "SELECT * FROM shifts WHERE tenant_id = ?";

        return jdbcTemplate.query(sqlStatement, new Object[]{tenantID}, (rs, rowNum) ->
                new ShiftDto(
                        (UUID) rs.getObject("id"),
                        (UUID) rs.getObject("shift_type_id"),
                        rs.getString("name"),
                        rs.getDate("date_start"),
                        rs.getDate("date_end"),
                        rs.getTime("time_start"),
                        rs.getTime("time_end"),
                        rs.getString("created_by"),
                        rs.getString("updated_by"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getString("time_zone"),
                        (UUID) rs.getObject("tenant_id"))
        );
    } catch (Exception e) {
        log.error("An exception had occurred in getShift: " + e);
        throw e;
    }
}
}