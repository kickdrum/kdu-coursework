package com.example.prashantminiproject.config;

import com.example.prashantminiproject.filter.TokenGeneratorFilter;
import com.example.prashantminiproject.filter.TokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig{
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers( "/api/v1/auth/register").permitAll()
                                .requestMatchers("/api/v1/auth/check").hasRole("USER")
                                .requestMatchers("/api/v1/house**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .csrf().disable();

        http.sessionManagement(
                session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.httpBasic(withDefaults());

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}