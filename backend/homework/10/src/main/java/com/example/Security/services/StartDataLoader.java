package com.example.Security.services;

import com.example.Security.entity.User;
import com.example.Security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartDataLoader  implements CommandLineRunner {
    UsersRepository userEntityRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public StartDataLoader(UsersRepository userEntityRepository,PasswordEncoder pass){
       this.passwordEncoder=pass;
        this.userEntityRepository = userEntityRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        userEntityRepository.addUserEntity(new User("Neer", passwordEncoder.encode("password"), "ROLE_ADMIN"));
        userEntityRepository.addUserEntity(new User("Jay", passwordEncoder.encode("password"), "ROLE_BASIC"));
    }
}
