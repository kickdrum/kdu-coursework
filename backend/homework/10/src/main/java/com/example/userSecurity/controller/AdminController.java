package com.example.userSecurity.controller;

//import com.example.userSecurity.exception.custom.BadRequestException;
//import com.example.userSecurity.exception.custom.CustomNullException;
//import com.example.userSecurity.exception.custom.ResourceNotFoundException;
import com.example.userSecurity.model.Person;
import com.example.userSecurity.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AdminController {
    private final PersonService personService;
    @Autowired
    AdminController(PersonService personService){
        this.personService=personService;
    }
    // POST : /user
    // {name: "abc", age: 12}
    @PostMapping("/admin")
    public ResponseEntity<String> addUser(@RequestBody Person person){
        log.error("Adding a new user to memory");
        personService.addPerson(person);
        return ResponseEntity.ok("User Added successfully!");
    }

    // GET : /search/user?name=Prashant
    @GetMapping("/admin/finduser")
    public Person searchUser(@RequestParam String name){
        log.info("searching user");
        Person temp = personService.getPersonUserName(name);
        return temp;
    }

    @GetMapping("/admin/getAllUsers")
    public List<Person> getAllUsers(){
        List<Person>users= personService.getAllUsers();
        return users;
    }
}
