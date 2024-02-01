package asish.kdu.spring_jpa_exercise.controller;

import asish.kdu.spring_jpa_exercise.entities.ShiftUsers;
import asish.kdu.spring_jpa_exercise.services.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShiftUserController {
    private ShiftUserService shiftUserService;
    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }
    @PostMapping("/shiftuser")
    public ResponseEntity<String> createShiftUser(@RequestBody ShiftUsers shiftUsers) {
        shiftUserService.addShiftUser(shiftUsers);
        return new ResponseEntity<>("Shift User created", HttpStatus.CREATED);
    }

    @DeleteMapping("/shiftuser")
    public ResponseEntity<String> deleteShiftUser(@RequestParam String id) {
        shiftUserService.deleteShiftUser(id);
        return new ResponseEntity<>("Shift User deleted", HttpStatus.CREATED);
    }
}
