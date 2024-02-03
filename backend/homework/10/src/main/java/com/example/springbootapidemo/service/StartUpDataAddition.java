package com.example.springbootapidemo.service;

import com.example.springbootapidemo.dao.PersonDAO;
import com.example.springbootapidemo.model.Person;
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
        personDAO.addPerson(new Person("Ravi", "ravi", passwordEncoder.encode("Testing123"), "ROLE_ADMIN"));
        personDAO.addPerson(new Person("XYZ", "xyz", passwordEncoder.encode("Testing123"), "ROLE_USER"));
    }
}
