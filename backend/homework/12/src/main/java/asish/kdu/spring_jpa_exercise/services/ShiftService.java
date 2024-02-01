package asish.kdu.spring_jpa_exercise.services;

import asish.kdu.spring_jpa_exercise.entities.Shift;
import asish.kdu.spring_jpa_exercise.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {
    private ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public void addShift(Shift shift) {
        shiftRepository.save(shift);
    }
}
