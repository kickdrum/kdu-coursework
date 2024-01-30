package com.example.userSecurity.controller;

import com.example.userSecurity.model.Person;
import com.example.userSecurity.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class BasicController {
    private final PersonService personService;
    @Autowired
    BasicController(PersonService personService){
        this.personService=personService;
    }
    // POST : /user
    // {name: "abc", age: 12}

    // GET : /search/user?name=Prashant
    @GetMapping("/user/finduser")
    public Person searchUser(@RequestParam String name){
        log.info("searching user");
        Person temp = personService.getPersonUserName(name);
        return temp;
    }

    @GetMapping("/user/getAllUsers")
    public List<Person> getAllUsers(){
        List<Person>users= personService.getAllUsers();
        return users;
    }
}
