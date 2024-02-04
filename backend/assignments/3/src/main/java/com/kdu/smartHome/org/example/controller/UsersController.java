package org.example.controller;


import org.example.entity.JwtRequest;
import org.example.entity.JwtResponse;
import org.example.entity.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class UsersController {

    @Autowired
    private UserService userService;

//    @GetMapping("/byName/{userName}")
//    public ResponseEntity<String> getUserByName(@PathVariable String userName) {
//        Users user = userService.getUserByName(userName);
//
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(user.getName(), HttpStatus.OK);
//    }
   @Autowired
AuthController authController;

    @GetMapping("/users")
    public List<Users> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }


    @PostMapping("/auth/register")
    public  ResponseEntity<JwtResponse> addUser(@RequestBody Users user, RedirectAttributes redirectAttributes) {
        userService.addUser(user);
        System.out.println("inside register");
        JwtRequest jwtRequest=new JwtRequest("arunain","abc");
        return  authController.login(jwtRequest);


//        return "redirect:/auth/login";


    }

    @PutMapping("/updateUser")
    public Users updateUser(@RequestBody Users user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        try{
            this.userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUser/{userId}")
    public Users getUserById(@PathVariable String userId){
        return this.userService.getUserById(userId);
    }

}
