package com.spring.jdbc.repository.tenant;

import com.spring.jdbc.entities.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TenantRepository {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<Tenant> findAll(){
        return jdbcTemplate.query("SELECT * FROM tenants", BeanPropertyRowMapper.newInstance(Tenant.class));
    }

    public int save(Tenant tenant){
        return jdbcTemplate.update("INSERT INTO tenants (id, name) VALUES(?,?)",
                new Object[] { tenant.getId(), tenant.getName()});
    }

    public int update(Tenant tenant){
        return jdbcTemplate.update("UPDATE tenants SET name =? WHERE id =?",
                new Object[] { tenant.getName(), tenant.getId()});
    }

    public Tenant findById(Long id){
        try {
            Tenant tenant = jdbcTemplate.queryForObject("SELECT * FROM tenants WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Tenant.class), id);

            return tenant;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
