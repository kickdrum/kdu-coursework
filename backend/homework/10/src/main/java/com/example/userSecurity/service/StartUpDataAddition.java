package com.example.userSecurity.service;

import com.example.userSecurity.dao.PersonDAO;
import com.example.userSecurity.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("Prashant", "prashant", passwordEncoder.encode("Prashant123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Priyank", "priyank", passwordEncoder.encode("Priyank123"), "ROLE_USER"));
    }
}
