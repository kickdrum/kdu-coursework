package asish.kdu.spring_jpa_exercise.repository;

import asish.kdu.spring_jpa_exercise.entities.Shift;
import asish.kdu.spring_jpa_exercise.entities.ShiftUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShiftUserRepository extends CrudRepository<ShiftUsers, String> {
    ShiftUsers getShiftUsersById(String id);

    ShiftUsers getShiftUsersByShift(Shift shift);
}
