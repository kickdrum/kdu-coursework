package asish.kdu.spring_jpa_exercise.repository;

import asish.kdu.spring_jpa_exercise.entities.Shift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface ShiftRepository extends CrudRepository<Shift, String> {
    Shift getShiftByName(String name);
    Shift findByTimeEnd(Time timeEnd);
}
