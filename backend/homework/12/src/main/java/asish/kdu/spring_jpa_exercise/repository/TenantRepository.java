package asish.kdu.spring_jpa_exercise.repository;

import asish.kdu.spring_jpa_exercise.entities.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends CrudRepository<Tenant, String> {
    Tenant getTenantByName(String name);
}
