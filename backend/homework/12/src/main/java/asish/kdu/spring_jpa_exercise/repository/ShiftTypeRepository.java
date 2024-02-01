package asish.kdu.spring_jpa_exercise.repository;

import asish.kdu.spring_jpa_exercise.entities.ShiftType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShiftTypeRepository extends CrudRepository<ShiftType, String> {
    ShiftType getShiftTypeByUniqueName(String uqName);
}
