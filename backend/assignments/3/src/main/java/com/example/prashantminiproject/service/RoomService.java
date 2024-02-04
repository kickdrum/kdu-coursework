package com.example.prashantminiproject.service;

import com.example.prashantminiproject.model.House;
import com.example.prashantminiproject.model.Room;
import com.example.prashantminiproject.repository.RoomRepository;
import com.example.prashantminiproject.repository.HouseRepository; // Add this import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }

    @Autowired
    private HouseRepository houseRepository; // Add this line

    public Room addRoomToHouse(Long houseId, Room room) {
        // Validate and handle logic for adding a room to a house
        // Set other necessary properties
        House house = houseRepository.findById(houseId).orElse(null);
//        if (house != null) {
//            room.setHouse(house);
//            return roomRepository.save(room);
//        }
        return null; // or throw an exception indicating the house was not found
    }

    // Implement other room-related methods as needed
}
