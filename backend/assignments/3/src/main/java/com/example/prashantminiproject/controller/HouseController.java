package com.example.prashantminiproject.controller;

import com.example.prashantminiproject.model.House;
import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/house")
public class HouseController {


    HouseService houseService;
    @Autowired
    public HouseController(HouseService houseService){
        this.houseService=houseService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addHouse(@RequestBody House house) {
        House addedHouse = houseService.addHouse(house);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "House added successfully");
        response.put("house", addedHouse);
        response.put("httpStatus", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<Map<String, String>> addUserToHouse(@PathVariable Long houseId, @RequestBody User users) {
        // Implement logic to add user to the house by houseId
        // Return appropriate response
        return ResponseEntity.ok(Map.of("message", "User added to house successfully"));
    }

}
