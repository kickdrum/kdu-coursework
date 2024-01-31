package com.example.prashantjdbc.dao;
import com.example.prashantjdbc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void saveUser(UserDto userDTO) {
        String sql = "INSERT INTO public.users(id, username, loggedin, time_zone, created_by, updated_by, created_at, updated_at, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                generateUUID(),
                userDTO.getUsername(),
                userDTO.getLoggedIn(),
                userDTO.getTimeZone(),
                userDTO.getCreatedBy(),
                userDTO.getUpdatedBy(),
                userDTO.getCreatedAt(),
                userDTO.getUpdatedAt(),
                userDTO.getTenantId());
    }
}
