package com.example.prashantminiproject.mapper;

import com.example.prashantminiproject.dto.RequestUserDto;
import com.example.prashantminiproject.filter.TokenGeneratorFilter;
import com.example.prashantminiproject.model.User;

public class UserMapper {

    public User mapUserDtoToUser(RequestUserDto requestUserDto) {
        User user = new User();
        user.setUsername(requestUserDto.getUsername());
        user.setPassword(requestUserDto.getPassword());
        user.setEmail(requestUserDto.getEmail());
        user.setFirstName(requestUserDto.getFirstName());
        user.setRole("ROLE_USER");
        user.setLastName(requestUserDto.getLastName());
        TokenGeneratorFilter tokenGeneratorFilter = new TokenGeneratorFilter();
        user.setToken(tokenGeneratorFilter.generateToken(requestUserDto.getUsername(), user.getRole()));
        return user;
    }
}