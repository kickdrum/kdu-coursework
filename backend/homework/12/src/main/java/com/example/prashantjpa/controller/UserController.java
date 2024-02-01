package com.example.prashantjpa.controller;

import com.example.prashantjpa.dto.UserDTO;
import com.example.prashantjpa.exception.UserNotFoundException;
import com.example.prashantjpa.entity.User;
import com.example.prashantjpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController

@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-user")
    public User createUser(@RequestBody User user) {
        log.info(user.toString());
        log.info("User Saved");
        return userService.saveUser(user);
    }
    @GetMapping("/findAllUsers")
    public Page<User> findAllUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "50") int size) {
        page = Math.max(page, 0);
        size = Math.min(Math.max(size, 1), 50);

        Pageable pageable = PageRequest.of(page, size);
        return userService.findAllUsers(pageable);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        try {
            userService.updateUserDetails(userId, userDTO);
            return ResponseEntity.ok("User Updated");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
