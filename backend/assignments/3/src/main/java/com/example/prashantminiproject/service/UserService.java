package com.example.prashantminiproject.service;

import com.example.prashantminiproject.dto.RequestUserDto;
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

    public User registerUser(RequestUserDto requestUserDto) {
        User user = userMapper.mapUserDtoToUser(requestUserDto);
        user.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
        return userRepository.save(user);
    }

//    public void validateUser(RequestUserDto requestUserDto) {
//        if (userRepository.findByUsername(requestUserDto.getUsername()) != null) {
//            throw new UserAlreadyExistException("User already exists");
//        }
//    }
//    public void validateUser(String username) {
//        if (userRepository.findByUsername(username) == null) {
//            throw new UserDoesntExistException("User does not exists");
//        }
//    }
//
//    public void validateAdminUser(String token) {
//        UserEntity userEntity = userRepository.findByToken(token);
//        if (!userEntity.getRole().equals("ROLE_ADMIN")) {
//            throw new OnlyAdminAllowedException("User is not admin");
//        }
//    }
}