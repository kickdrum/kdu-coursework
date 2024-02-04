package org.example.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().
                username("arunain")
                .password(passwordEncoder().encode("abc")).roles("ADMIN").
                build();

        UserDetails user2 = User.builder().
                username("aakash")
                .password(passwordEncoder().encode("abc")).roles("BASIC").
                build();
//        List<GrantedAuthority> authorities=null;
//        authorities.add(new SimpleGrantedAuthority(User.getRole()));
//        return new User(personname,personPassword,authorities);

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}