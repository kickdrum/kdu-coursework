package com.example.springbootapidemo.config;

import com.example.springbootapidemo.model.Person;
import com.example.springbootapidemo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomAuthenticationManager implements AuthenticationProvider {
    PersonService personService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationManager(PersonService personService, PasswordEncoder passwordEncoder){
        this.passwordEncoder =passwordEncoder;
        this.personService = personService;
    }

    /**
     *
     * @param authentication the authentication request object.
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("authenticate started....");
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Person person = personService.getPersonUsername(username);

        log.info("person object" + person.toString());

        if(person == null){
            throw new BadCredentialsException("No user registered with this details!");
        }else{
            if (passwordEncoder.matches(pwd, person.getPassword())) {
                log.info("password matched...");
                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(person.getRole()));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }
    }

    /**
     *
     * @param authentication
     * @return
     */

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    /**
     *
     * @param role
     * @return
     */
    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        return grantedAuthorities;
    }
}
