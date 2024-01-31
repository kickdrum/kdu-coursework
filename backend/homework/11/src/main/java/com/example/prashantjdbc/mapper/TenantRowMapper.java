package com.example.prashantjdbc.mapper;
import com.example.prashantjdbc.model.Tenant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class TenantRowMapper implements RowMapper<Tenant> {
    @Override
    public Tenant mapRow(ResultSet result, int rowNum) throws SQLException {
        Tenant tenant = new Tenant();
        tenant.setId(UUID.fromString(result.getString("id")));
        tenant.setCreatedBy(result.getString("createdBy"));
        tenant.setUpdatedBy(result.getString("updatedBy"));
        tenant.setCreatedAt(result.getTimestamp("createdAt"));
        tenant.setUpdatedAt(result.getTimestamp("updatedAt"));
        return tenant;
    }
}