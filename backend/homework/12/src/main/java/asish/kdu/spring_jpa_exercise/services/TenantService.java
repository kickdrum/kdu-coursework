package asish.kdu.spring_jpa_exercise.services;

import asish.kdu.spring_jpa_exercise.entities.Tenant;
import asish.kdu.spring_jpa_exercise.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    private TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }
    public void addTenant(Tenant tenant) {
        tenantRepository.save(tenant);
    }
}
