package asish.kdu.spring_jpa_exercise.controller;

import asish.kdu.spring_jpa_exercise.entities.ShiftType;
import asish.kdu.spring_jpa_exercise.services.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ShiftTypeController {
    private ShiftTypeService shiftTypeService;

    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @PostMapping("/shifttype")
    public ResponseEntity<String> createShiftType(@RequestBody ShiftType shiftType) {
        shiftTypeService.addShiftType(shiftType);
        return new ResponseEntity<>("Shift type created", HttpStatus.CREATED);
    }
}
