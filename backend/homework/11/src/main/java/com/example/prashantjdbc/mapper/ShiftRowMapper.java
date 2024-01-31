package com.example.prashantjdbc.mapper;

import com.example.prashantjdbc.model.Shift;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ShiftRowMapper implements RowMapper<Shift> {
    @Override
    public Shift mapRow(ResultSet result, int rowNum) throws SQLException {
        Shift shift = new Shift();
        shift.setId(UUID.fromString(result.getString("id")));
        shift.setShiftTypeId(UUID.fromString(result.getString("shiftTypeId")));
        shift.setName(result.getString("name"));
        shift.setDateStart(new Date(result.getDate("dateStart").getTime()));
        shift.setDateEnd(new Date(result.getDate("dateEnd").getTime()));
        shift.setTimeStart(new Time(result.getTime("timeStart").getTime()));
        shift.setTimeEnd(new Time(result.getTime("timeEnd").getTime()));
        shift.setCreatedAt(result.getTimestamp("createdAt"));
        shift.setCreatedBy(result.getString("createdBy"));
        shift.setUpdatedBy(result.getString("updatedBy"));
        shift.setUpdatedAt(result.getTimestamp("updatedAt"));
        shift.setTimeZone(result.getString("timeZone"));
        shift.setTenantId(UUID.fromString(result.getString("tenantId")));
        return shift;
    }
}
