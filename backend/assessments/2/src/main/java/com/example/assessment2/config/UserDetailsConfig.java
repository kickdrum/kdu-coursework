package com.example.assessment2.config;

import com.example.assessment2.dto.UserDto;
import com.example.assessment2.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsConfig implements UserDetailsService {
    private final UserService userService;
    public UserDetailsConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDto user = userService.getUserByName(name);
        String userName = null;
        String userPassword = null;
        List<GrantedAuthority> authorities = null;

        if(user == null){
            throw new UsernameNotFoundException("User details not found for username : " + name);
        }else{
            userName = user.getUserName();
            userPassword = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }
        return new User(userName, userPassword, authorities);
    }
}
