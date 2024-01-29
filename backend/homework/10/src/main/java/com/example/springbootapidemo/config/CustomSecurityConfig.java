package com.example.springbootapidemo.config;

import com.example.springbootapidemo.filter.TokenGeneratorFilter;
import com.example.springbootapidemo.filter.TokenValidatorFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
public class CustomSecurityConfig {
    /**
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {

        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/user").hasRole("BASIC")
                        .requestMatchers(HttpMethod.GET,"/user").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/user/**").hasRole("BASIC")
                        .requestMatchers( "/user/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(ex->log.error(ex.toString()));
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    /**
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
