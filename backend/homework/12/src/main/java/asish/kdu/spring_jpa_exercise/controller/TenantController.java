package asish.kdu.spring_jpa_exercise.controller;

import asish.kdu.spring_jpa_exercise.entities.Tenant;
import asish.kdu.spring_jpa_exercise.services.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class TenantController {
    private TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/tenant")
    public ResponseEntity<String> createTenant(@RequestBody Tenant tenant) {
        tenantService.addTenant(tenant);
        log.info(tenant.toString());
        return new ResponseEntity<>("Tenant Created successfully", HttpStatus.CREATED);
    }
}
