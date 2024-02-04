package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.RegisterRequesDTO;
import com.kdu.smarthome.dto.response.RegisterResponseDTO;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.dto.request.LoginRequestDTO;
import com.kdu.smarthome.dto.response.LoginResponseDTO;
import com.kdu.smarthome.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {

    AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }


    /**
     *
     * @param registerRequesDTO
     * @return RegisterResponseDTO
     * @throws InvalidCredentialsException
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequesDTO registerRequesDTO) throws InvalidCredentialsException {

        log.info("POST: /api/v1/auth/register");
        log.debug("Request data: " + registerRequesDTO);

        RegisterResponseDTO registerResponseDTO = authService.register(registerRequesDTO);

        return new ResponseEntity<>(registerResponseDTO, HttpStatus.OK);
    }


    /**
     *
     * @param loginRequestDTO
     * @return LoginResponseDTO
     * @throws InvalidCredentialsException
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) throws InvalidCredentialsException {

        log.info("POST: /api/v1/auth/login");
        log.debug("Request data: " + loginRequestDTO);

        LoginResponseDTO loginResponseDTO = authService.login(loginRequestDTO);

        return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
    }
}