package spring.assignment.assignment2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.assignment.assignment2.dto.UserDto;
import spring.assignment.assignment2.models.Users;
import spring.assignment.assignment2.repo.UserRepository;
import spring.assignment.assignment2.util.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDetailsConfig implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(email);
        String userEmail;
        String userName;
        String userPassword;
        UserRole userRole;
        long userId;

        if(user == null){
            throw new UsernameNotFoundException("Users details not found for email-id : " + email);
        }else{
            userId = user.getUserId();
            userName = user.getName();
            userPassword = user.getPassword();
            userEmail = user.getEmail();
            userRole = user.getRole();
        }
        return new Users(userId,userName, userEmail, userPassword, userRole) {
        };
    }
}
