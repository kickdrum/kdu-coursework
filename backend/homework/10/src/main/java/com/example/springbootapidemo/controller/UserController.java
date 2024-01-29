package com.example.springbootapidemo.controller;

import com.example.springbootapidemo.dto.request.UserReqDTO;
import com.example.springbootapidemo.dto.response.UserDTO;
import com.example.springbootapidemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Method: GET
     * to get all users
     * @return List<UserDTO>
     */
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userList = userService.getList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * Method: GET
     * @param userName
     * @return UserDTO
     */
    @GetMapping("/user/{userName}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String userName){
        UserDTO user = userService.getUser(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Method: POST
     * @param userDTO
     * @return String
     */
    @PostMapping("/user")
    public ResponseEntity<String> getUser(@RequestBody UserReqDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<>("User added successfully!!!", HttpStatus.CREATED);
    }

    /**
     * Method: GET
     * @return String
     */
    @GetMapping("/test")
    public String test(){
        log.info("Authorization testing: user logged in....");
        return "user is logged in....";
    }
}
