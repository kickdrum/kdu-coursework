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
    private final HouseRepository houseRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, HouseRepository houseRepository){
        this.roomRepository = roomRepository;
        this.houseRepository = houseRepository;
    }

    public Room addRoomToHouse(Long houseId, Room room) {
        House house = houseRepository.findById(houseId).orElse(null);
        if (house != null) {
            room.setHouse(house);
            return roomRepository.save(room);
        }
        return null;
    }
}