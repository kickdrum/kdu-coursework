package com.example.prashantminiproject.service;

import com.example.prashantminiproject.dto.UserDto;
import com.example.prashantminiproject.mapper.UserMapper;
import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private final UserMapper userMapper = new UserMapper();

    public User registerUser(UserDto userDto) {
        User user = userMapper.mapUserDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}