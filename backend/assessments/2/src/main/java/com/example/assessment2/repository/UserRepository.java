package com.example.assessment2.repository;

import com.example.assessment2.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public List<UserDto> getAllUsers() {
        return users;
    }

    public UserDto getUserByName(String name) {
        for (UserDto user : users) {
            if (user.getUserName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(UserDto userDto) {
        users.add(userDto);
    }
}
