package asish.kdu.spring_jpa_exercise.services;

import asish.kdu.spring_jpa_exercise.entities.ShiftUsers;
import asish.kdu.spring_jpa_exercise.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Optional;

@Service
public class ShiftUserService {
    private ShiftUserRepository shiftUserRepository;

    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    public void addShiftUser(ShiftUsers shiftUsers) {
        shiftUserRepository.save(shiftUsers);
    }

    public void deleteShiftUser(String id) {
        Optional<ShiftUsers> shiftUserOptional = shiftUserRepository.findById(id);

        if (shiftUserOptional.isPresent()) {
            ShiftUsers shiftUser = shiftUserOptional.get();
            if (shiftUser.getShift().getTimeEnd().equals(Time.valueOf("23:00:00"))) {
                shiftUserRepository.delete(shiftUser);
            }
        }
    }
}
