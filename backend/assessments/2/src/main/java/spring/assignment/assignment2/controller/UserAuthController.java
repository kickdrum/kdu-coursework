package spring.assignment.assignment2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.assignment.assignment2.dto.UserDto;
import spring.assignment.assignment2.models.Address;
import spring.assignment.assignment2.service.UserAuthService;
import spring.assignment.assignment2.service.UserInfoService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/info")
public class UserAuthController {

    private final UserInfoService infoService;

    @GetMapping("/address")
    public ResponseEntity<Set<Address>> register(String email) {
        Set<Address> addresses = infoService.getUserAddress(email);
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }
}