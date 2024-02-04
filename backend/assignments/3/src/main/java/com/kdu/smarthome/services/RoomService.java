package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddRoomRequestDTO;
import com.kdu.smarthome.dto.response.AddRoomResponseDTO;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.models.Rooms;
import com.kdu.smarthome.repositories.HouseRepository;
import com.kdu.smarthome.repositories.RoomsRepository;
import com.kdu.smarthome.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
public class RoomService {

    RoomsRepository roomsRepository;
    HouseRepository houseRepository;
    UserRepository userRepository;

    public RoomService(HouseRepository houseRepository,
                        UserRepository userRepository,
                        RoomsRepository roomsRepository){
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.roomsRepository = roomsRepository;
    }


    /**
     *
     * @param id
     * @param addRoomRequestDTO
     * @return AddRoomResponseDTO
     * @throws ResourceNotFoundException
     * @throws InvalidCredentialsException
     */
    public AddRoomResponseDTO addRooms(String id, AddRoomRequestDTO addRoomRequestDTO) throws ResourceNotFoundException, InvalidCredentialsException {

        // fetching username from JWT security context
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("[RoomService - addRooms] - authenticatedUsername: " + authenticatedUsername);

        // checking if house is valid or not
        Long houseID = Long.parseLong(id);
        House house = houseRepository.findById(houseID).orElse(new House());

        if(house.getHouseName() == null){
            throw new ResourceNotFoundException("House ID does not exists");
        }

        // checking if authenticated user is house owner or not
        String houseAdmin = house.getUsers().getUsername();

        if(!houseAdmin.equals(authenticatedUsername)){
            throw new InvalidCredentialsException("Only admin can add users");
        }

        // destructuring DTO
        String roomName = addRoomRequestDTO.getRoomName();

        // saving room in database
        Rooms rooms = new Rooms(roomName);
        Rooms newRoom = roomsRepository.save(rooms);
        log.debug("NewRoom created: " + newRoom);

        // adding room details in house list
        List<Rooms> roomsList = house.getRoomsList();
        roomsList.add(newRoom);
        house.setRoomsList(roomsList);

        // saving details in database
        houseRepository.save(house);

        return new AddRoomResponseDTO("Room added successfully!!",
                newRoom,
                HttpStatus.OK);
    }


}
