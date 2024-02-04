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
    private HouseRepository houseRepository;

    public Room addRoomToHouse(Long houseId, Room room) {
        House house = houseRepository.findById(houseId).orElse(null);

        return null;
    }

}
