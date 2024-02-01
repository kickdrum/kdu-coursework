package com.example.prashantjpa.service;

import com.example.prashantjpa.dto.UserDTO;
import com.example.prashantjpa.entity.User;
import com.example.prashantjpa.repository.UserRepo;
import com.example.prashantjpa.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public Page<User> findAllUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    public void updateUserDetails(UUID userId, UserDTO userDTO) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }


}
