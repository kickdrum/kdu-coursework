package com.example.assessment2.service;

import com.example.assessment2.dto.UserDto;
import com.example.assessment2.exception.custom.MyCustomException;
import com.example.assessment2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() throws RuntimeException {
        try {
            List<UserDto> users = userRepository.getAllUsers();
            if(users.isEmpty()){
                throw new MyCustomException("No users found in the database");
            }
            return users;
        } catch (MyCustomException e) {
            throw new MyCustomException(e.getMessage());
        }
    }

    public UserDto getUserByName(String name) throws RuntimeException{
        try {
            UserDto user = userRepository.getUserByName(name);
            if (user != null) {
                return user;
            }
            throw new MyCustomException("No user found with name " + name);
        } catch (MyCustomException e) {
            throw new MyCustomException(e.getMessage());
        }
    }

    public UserDto addUser(UserDto userDto) {
        try {
            userRepository.addUser(userDto);
            return userDto;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding user");
        }
    }
}
