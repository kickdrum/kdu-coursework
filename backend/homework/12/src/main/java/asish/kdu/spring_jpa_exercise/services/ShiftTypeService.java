package asish.kdu.spring_jpa_exercise.services;

import asish.kdu.spring_jpa_exercise.entities.ShiftType;
import asish.kdu.spring_jpa_exercise.repository.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftTypeService {
    private ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository) {
        this.shiftTypeRepository = shiftTypeRepository;
    }

    public void addShiftType(ShiftType shiftType) {
        shiftTypeRepository.save(shiftType);
    }
}
