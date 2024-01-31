package com.spring.jdbc.repository.shiftuser;

import com.spring.jdbc.entities.ShiftUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShiftUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ShiftUser> findAll() {
        return jdbcTemplate.query("SELECT * FROM shift_users", BeanPropertyRowMapper.newInstance(ShiftUser.class));
    }

    public int save(ShiftUser shiftUser) {
        return jdbcTemplate.update("INSERT INTO shift_users (id, shiftId, userId, tenantId) " +
                        "VALUES (?, ?, ?, ?)",
                shiftUser.getId(), shiftUser.getShiftId(), shiftUser.getUserId(), shiftUser.getTenantId());
    }
}
