package asish.kdu.spring_jpa_exercise.controller;

import asish.kdu.spring_jpa_exercise.entities.User;
import asish.kdu.spring_jpa_exercise.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(user, id);
        log.info(user.toString());
        log.info(id);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<User>> findAllUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "50") int pageSize
    ) {
        Page<User> entity = userService.findAllUsers(pageNumber, pageSize);
        log.info(entity.toString());
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
