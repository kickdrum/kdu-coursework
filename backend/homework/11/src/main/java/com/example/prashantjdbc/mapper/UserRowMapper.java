package com.example.prashantjdbc.mapper;

import com.example.prashantjdbc.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet result, int rowNum) throws SQLException {
        User user = new User();
        user.setId(UUID.fromString(result.getString("id")));
        user.setUsername(result.getString("username"));
        user.setLoggedIn(result.getInt("loggedIn"));
        user.setTimeZone(result.getString("timeZone"));
        user.setCreatedBy(result.getString("createdBy"));
        user.setUpdatedBy(result.getString("updatedBy"));
        user.setCreatedAt(result.getTimestamp("createdAt"));
        user.setUpdatedAt(result.getTimestamp("updatedAt"));
        user.setTenantId(UUID.fromString(result.getString("tenantId")));
        return user;
    }
}
