package com.kdu.smarthome.services;

import com.kdu.smarthome.auth.JwtUtil;
import com.kdu.smarthome.dto.request.LoginRequestDTO;
import com.kdu.smarthome.dto.request.RegisterRequesDTO;
import com.kdu.smarthome.dto.response.LoginResponseDTO;
import com.kdu.smarthome.dto.response.RegisterResponseDTO;
import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repositories.UserRepository;
import com.kdu.smarthome.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    UserRepository userRepository;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    /**
     *
     * @param registerRequesDTO
     * @return RegisterResponseDTO
     */

    public RegisterResponseDTO register(RegisterRequesDTO registerRequesDTO) {

        // saving user in Database
        Users user = Mapper.getUserFromRegisterDTO(registerRequesDTO);
        userRepository.save(user);

        // generating token
        String token = jwtUtil.createToken(user);

        return new RegisterResponseDTO("user registered successfully!!!", token);
    }

    /**
     *
     * @param loginRequestDTO
     * @return LoginResponseDTO
     */
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        // destructuring data
        String username = loginRequestDTO.getUsername();
        String password = loginRequestDTO.getPassword();

        log.debug("Auth-service [Login]: " + username + " "  + password);


        // authenticating user
        authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                username, password
                        )
        );

        Users currentUser = userRepository.findByUsername(username);
        String token = jwtUtil.createToken(currentUser);

        return new LoginResponseDTO("user logged in successfully!!!", token);
    }
}
