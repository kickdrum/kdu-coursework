package com.example.springbootapidemo.service;

import com.example.springbootapidemo.dao.PersonDAO;
import com.example.springbootapidemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {

    PersonDAO personDAO;
    PasswordEncoder passwordEncoder;

    @Autowired
    public StartUpDataAddition(PersonDAO personDAO, PasswordEncoder passwordEncoder){
        this.personDAO = personDAO;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     *
     * @param args incoming main method arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        String basic = "basic";
        String admin = "admin";

        personDAO.addPerson(new Person(basic, basic, passwordEncoder.encode(basic), "ROLE_BASIC"));
        personDAO.addPerson(new Person(admin, admin, passwordEncoder.encode(admin), "ROLE_ADMIN"));
    }
}
