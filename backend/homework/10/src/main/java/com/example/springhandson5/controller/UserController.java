package com.example.springhandson5.controller;

import com.example.springhandson5.exception.custom.CustomException;
import com.example.springhandson5.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    List<User> userList = new ArrayList<>();
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        log.info("Adding a new User");
        userList.add(user);
        return ResponseEntity.ok("Successfully Added a new User");
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User user = null;
        try{
            user = userList.get(id);
        }catch(IndexOutOfBoundsException ex){
            throw new CustomException("No data of id - " + id + "in storage");
        }
        return user;
    }
    @GetMapping("/search/user")
    public User searchUser(@RequestParam String name){
        log.info("searching user");
        User temp = null;
        for (User user: userList){
            if (user.getUserName().equals(name)){
                temp = user;
            }
        }
        return temp;
    }

    @GetMapping("/user-all")
    public List<User> getAllUser(){
        return userList;
    }
}
