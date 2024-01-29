package com.example.userSecurity.controller;

//import com.example.userSecurity.exception.custom.BadRequestException;
//import com.example.userSecurity.exception.custom.CustomNullException;
//import com.example.userSecurity.exception.custom.ResourceNotFoundException;
import com.example.userSecurity.model.User;
        import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
        import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    List<User> userList = new ArrayList<>();

    // POST : /user
    // {name: "abc", age: 12}
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        logger.error("Adding a new user to memory");
        userList.add(user);
        return ResponseEntity.ok("User Added successfully!");
    }

    // GET : /user/2
//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable int id){
//        User user = null;
//        try{
//            user = userList.get(id);
//        }catch(IndexOutOfBoundsException ex){
//            throw new MyCustomException("No data of id - " + id + "in storage");
//        }
//        return userList.get(id);
//    }

    // GET : /search/user?name=Prashant
    @GetMapping("/search/user")
    public User searchUser(@RequestParam String name){
        logger.info("searching user");
        User temp = null;
        for (User user: userList){
            if (user.getUserName().equals(name)){
                temp = user;
            }
        }
        return temp;
    }
}
