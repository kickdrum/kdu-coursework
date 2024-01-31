package com.spring.jdbc.controllers;

import com.spring.jdbc.entities.Tenant;
import com.spring.jdbc.repository.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping
    public List<Tenant> getAllTenants(){
        return tenantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id){
        Tenant tenant = tenantRepository.findById(id);
        return new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant){
        tenantRepository.save(tenant);
        return new ResponseEntity<Tenant>(tenant, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant tenant){
        tenantRepository.update(tenant);
        return new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
    }
}
