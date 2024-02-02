package com.example.assesment2.controller;

import com.example.assesment2.dto.AddressDto;
import com.example.assesment2.entity.Address;
import com.example.assesment2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{email}")
    public ResponseEntity<?> addAddress(@RequestBody AddressDto addressDto, @PathVariable String email) {
        Address newAddress = addressService.addAddress(addressDto, email);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }
}
