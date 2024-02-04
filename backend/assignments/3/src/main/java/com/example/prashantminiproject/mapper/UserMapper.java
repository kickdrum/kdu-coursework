package com.example.prashantminiproject.mapper;

import com.example.prashantminiproject.dto.UserDto;
import com.example.prashantminiproject.filter.TokenGeneratorFilter;
import com.example.prashantminiproject.model.User;

public class UserMapper {

    public User mapUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setRole("ROLE_USER");
        user.setLastName(userDto.getLastName());
        TokenGeneratorFilter tokenGeneratorFilter = new TokenGeneratorFilter();
        user.setToken(tokenGeneratorFilter.generateToken(userDto.getUsername(), user.getRole()));
        return user;
    }
}