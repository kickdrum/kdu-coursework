package com.example.assesment2.service;

import com.example.assesment2.dto.AddressDto;
import com.example.assesment2.entity.Address;
import com.example.assesment2.entity.Users;
import com.example.assesment2.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserService userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    public Address addAddress(AddressDto addressDto, String userEmail) {
        Users user = userService.getUserByEmail(userEmail);
        //street city state postalCode nickname
        Address newAddress = new Address();
        newAddress.setStreet(addressDto.getStreet());
        newAddress.setCity(addressDto.getCity());
        newAddress.setState(addressDto.getState());
        newAddress.setPostalCode(addressDto.getPostalCode());
        newAddress.setNickname(addressDto.getNickname());
        newAddress.setUser(user);

        return addressRepository.save(newAddress);
    }
}
