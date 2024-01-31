package com.spring.jdbc.repository.user;

import com.spring.jdbc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<User> findAll(){
        return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }

    public int save(User user){
        return jdbcTemplate.update("INSERT INTO users (id, username, loggedIn, timeZone, tenantId) VALUES(?,?,?,?,?)",
                new Object[] { user.getId(), user.getUsername(), user.getLoggedIn(), user.getTimeZone(), user.getTenantId()});
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET id = ?, username = ?, loggedIn = ?, timeZone = ?, tenantId = ? WHERE id = ?",
                user.getId(), user.getUsername(), user.getLoggedIn(), user.getTimeZone(), user.getTenantId(), user.getId());
    }
}

