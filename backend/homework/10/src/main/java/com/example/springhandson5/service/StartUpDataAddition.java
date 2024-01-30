package com.example.springhandson5.service;

import com.example.springhandson5.dao.PersonDAO;
import com.example.springhandson5.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {
    PersonDAO personDAO;
    PasswordEncoder passwordEncoder;

    @Autowired
    public StartUpDataAddition(PersonDAO personDAO, PasswordEncoder passwordEncoder) {
        this.personDAO = personDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        personDAO.addPerson(new Person("person", "person", passwordEncoder.encode("Testing123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("Ajay", "ajay", passwordEncoder.encode("Testing123"), "ROLE_USER"));
    }
}
