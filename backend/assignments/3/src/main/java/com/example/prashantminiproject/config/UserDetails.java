package com.example.prashantminiproject.config;

import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetails implements UserDetailsService {


    UserRepository userRepository;

    @Autowired
    public UserDetails(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User person = userRepository.findByUsername(username);
        String personUserName = null;
        String personPassword = null;
        List<GrantedAuthority> authorities = null;

        if(person == null){
            throw new UsernameNotFoundException("User details not found for user : " + username + ". Please register fist.");
        }else{
            personUserName = person.getUsername();
            personPassword = person.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(person.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(personUserName, personPassword, authorities);
    }
}