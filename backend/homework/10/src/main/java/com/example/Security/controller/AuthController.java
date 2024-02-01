package com.example.Security.controller;
import com.example.Security.dto.Authdto;
import com.example.Security.securityacc.CustomAuthManager;
import com.example.Security.securityacc.TokenGeneratorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/authorize")
public class AuthController {
    private final CustomAuthManager customAuthManager;
    private final TokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    public AuthController(CustomAuthManager customAuthManager, TokenGeneratorFilter tokenGeneratorFilter) {
        this.customAuthManager = customAuthManager;
        this.tokenGeneratorFilter = tokenGeneratorFilter;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Authdto requestLoginDTO) {

        try {
            Authentication authentication = customAuthManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestLoginDTO.getUserName(), requestLoginDTO.getPassword())
            );
            String token = tokenGeneratorFilter.generateJWT(authentication);
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
