package com.example.prashantjdbc.mapper;
import com.example.prashantjdbc.model.ShiftUser;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class ShiftUserRowMapper implements RowMapper<ShiftUser> {
    @Override
    public ShiftUser mapRow(ResultSet result, int rowNum) throws SQLException {
        ShiftUser shiftUser = new ShiftUser();
        shiftUser.setId(UUID.fromString(result.getString("id")));
        shiftUser.setShiftId(UUID.fromString(result.getString("shiftId")));
        shiftUser.setUserId(UUID.fromString(result.getString("userId")));
        shiftUser.setCreatedBy(result.getString("createdBy"));
        shiftUser.setUpdatedBy(result.getString("updatedBy"));
        shiftUser.setCreatedAt(result.getTimestamp("createdAt"));
        shiftUser.setUpdatedAt(result.getTimestamp("updatedAt"));
        shiftUser.setTenantId(UUID.fromString(result.getString("tenantId")));
        return shiftUser;
    }
}
