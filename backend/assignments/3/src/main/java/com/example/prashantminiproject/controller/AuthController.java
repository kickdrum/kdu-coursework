package com.example.prashantminiproject.controller;
import com.example.prashantminiproject.dto.RegistrationSuccessDto;
import com.example.prashantminiproject.dto.UserDto;
import com.example.prashantminiproject.filter.TokenGeneratorFilter;
import com.example.prashantminiproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    UserService userService;
    PasswordEncoder passwordEncoder;
    public AuthController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationSuccessDto> register(@RequestBody UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.addUser(userDto);
        String token = TokenGeneratorFilter.generateToken(userDto.getUsername(), "ROLE_USER");
        return new ResponseEntity<>(new RegistrationSuccessDto("Registration success",token), HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<RegistrationSuccessDto> check(){
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(new RegistrationSuccessDto("Reached", user), HttpStatus.OK);
    }
}