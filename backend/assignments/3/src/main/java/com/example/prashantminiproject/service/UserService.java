package com.example.prashantminiproject.service;

import com.example.prashantminiproject.exception.custom.NoUserFoundException;
import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.dto.UserDto;
import com.example.prashantminiproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() throws NoUserFoundException {
        try {
            List<User> users = userRepository.findAll();
            if(users.isEmpty()){
                throw new NoUserFoundException("No UsersRepository found in the database");
            }
            return users;
        } catch (NoUserFoundException e) {
            throw new NoUserFoundException(e.getMessage());
        }
    }

    public User getUserByName(String name){
        Optional<User> user = userRepository.findById(name);

        if (user.isPresent()) {
            return user.get();
        }
        throw new NoUserFoundException("No user found with name " + name);

    }

    public void addUser(UserDto userDto) {
        try {
            User newUser = new User();
            newUser.setUsername(userDto.getUsername());
            newUser.setName(userDto.getName());
            newUser.setEmailId(userDto.getEmailId());
            newUser.setPassword(userDto.getPassword());
            newUser.setFirstName(userDto.getFirstname());
            newUser.setLastName(userDto.getLastname());
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding user");
        }
    }


}

//    public User getUserByUsername(String username) {
//        Optional<User> userOptional = userRepository.findUserByUsername(username);
//        return userOptional.orElse(null);
//    }

