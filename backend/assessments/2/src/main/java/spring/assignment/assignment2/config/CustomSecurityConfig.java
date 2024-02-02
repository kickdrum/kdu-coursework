package spring.assignment.assignment2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import spring.assignment.assignment2.util.jwt.TokenGeneratorFilter;
import spring.assignment.assignment2.util.jwt.TokenValidatorFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@SuppressWarnings("all")
@Configuration
public class CustomSecurityConfig {
    @Bean
    public SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        requests -> requests
                        .requestMatchers( "/person/login").permitAll()
                        .requestMatchers("/add/user").hasRole("ADMIN")
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
