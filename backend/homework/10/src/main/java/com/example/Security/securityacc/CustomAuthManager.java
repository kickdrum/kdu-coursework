package com.example.Security.securityacc;


import com.example.Security.entity.User;
import com.example.Security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomAuthManager implements AuthenticationProvider {
    UserService userEntityService;
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public CustomAuthManager(UserService userEntityService){
        this.userEntityService = userEntityService;
    }
    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getClass().toString();
        User userEntity = userEntityService.getPersonUsername(username);

        if(userEntity == null){
            throw new BadCredentialsException("No user registered with this details!");
        }else{
            if (!passwordEncoder().matches(password, userEntity.getPassword())) {
                throw new BadCredentialsException("Invalid password!");
            } else {
                return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(userEntity.getRole()));
            }
        }
    }



    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        return grantedAuthorities;
    }


}
