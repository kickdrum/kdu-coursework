package asish.kdu.spring_jpa_exercise.controller;

import asish.kdu.spring_jpa_exercise.entities.Shift;
import asish.kdu.spring_jpa_exercise.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ShiftController {
    private ShiftService shiftService;
    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/shift")
    public ResponseEntity<String> createShift(@RequestBody Shift shift) {
        shiftService.addShift(shift);
        return new ResponseEntity<>("Shift created successfully", HttpStatus.CREATED);
    }
}
