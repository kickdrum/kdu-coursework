package com.example.prashantminiproject.service;

import com.example.prashantminiproject.model.House;
//import com.example.prashantminiproject.model.Users;
import com.example.prashantminiproject.model.User;
import com.example.prashantminiproject.repository.HouseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository){
        this.houseRepository = houseRepository;
    }

    public House addHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House getHouseById(Long houseId) {
        return houseRepository.findById(houseId).orElse(null);
    }

    public void updateHouseAddress(Long houseId, String newAddress) {
        House house = houseRepository.findById(houseId).orElse(null);
        if (house != null) {
            house.setAddress(newAddress);
            houseRepository.save(house);
        }
    }

    public void addUserToHouse(Long houseId, User user) {
        House house = houseRepository.findById(houseId).orElse(null);
        if (house != null) {
            house.addUser(user);
            houseRepository.save(house);
        }
    }
}