package org.example.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.example.dto.RoomRequest;
import org.example.dto.RoomResponse;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping("/api/v1/room")
    public ResponseEntity<RoomResponse> addRoom(@RequestParam String houseId, @RequestBody RoomRequest roomRequest, HttpServletRequest request){
        RoomResponse roomResponse = roomService.addRoom(Long.parseLong(houseId),roomRequest.getRoomName());
        return new ResponseEntity<>(roomResponse, HttpStatus.OK);
    }
}










