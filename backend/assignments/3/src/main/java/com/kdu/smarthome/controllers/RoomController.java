package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddRoomRequestDTO;
import com.kdu.smarthome.dto.response.AddRoomResponseDTO;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.services.RoomService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
@Slf4j
public class RoomController {

    RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }


    /**
     *
     * @param addRoomRequestDTO
     * @param houseId
     * @return AddRoomResponseDTO
     * @throws InvalidCredentialsException
     * @throws ResourceNotFoundException
     */
    @PostMapping("")
    public ResponseEntity<AddRoomResponseDTO> addHouse(@Valid @RequestBody AddRoomRequestDTO addRoomRequestDTO, @RequestParam String houseId) throws InvalidCredentialsException, ResourceNotFoundException {

        log.info("POST: /api/v1/room");

        AddRoomResponseDTO addRoomResponseDTO = roomService.addRooms(houseId, addRoomRequestDTO);
        return new ResponseEntity<>(addRoomResponseDTO, HttpStatus.OK);
    }
}
