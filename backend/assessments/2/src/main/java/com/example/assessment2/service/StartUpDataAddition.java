package com.example.assessment2.service;

import com.example.assessment2.dto.UserDto;
import com.example.assessment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.addUser(new UserDto("ABC", passwordEncoder.encode("test123"), "xyz@kickdrum.com", "ROLE_ADMIN"));
        userRepository.addUser(new UserDto("XYZ", passwordEncoder.encode("test123"), "abc@kickdrum.com", "ROLE_USER"));
    }
}
