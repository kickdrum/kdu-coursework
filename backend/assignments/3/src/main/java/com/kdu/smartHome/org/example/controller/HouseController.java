package org.example.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.example.dto.*;
import org.example.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class HouseController {
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }
    @PostMapping("/api/v1/house")
    public ResponseEntity<HouseResponse> addHouse(@RequestBody HouseRequest houseRequest, HttpServletRequest request){

        HouseResponse houseResponse = houseService.addHouse(houseRequest);
        return new ResponseEntity<>(houseResponse, HttpStatus.OK);
    }

    @PostMapping("/api/v1/house/{houseId}/add-user")
    public ResponseEntity<AddUserTOHouseResponse> addUser(@PathVariable String houseId, @RequestBody AddUserToHouseRequest addUserToHouseRequest, HttpServletRequest request) {

        AddUserTOHouseResponse addUserTOHouseResponse = houseService.addUser(Long.parseLong(houseId), addUserToHouseRequest);
        return new ResponseEntity<>(addUserTOHouseResponse, HttpStatus.OK);

    }

    @GetMapping("/api/v1/house")
    public ResponseEntity<GetHouseResponse> getHouses() {
        GetHouseResponse getHouseResponse = houseService.getAll();
        return new ResponseEntity<>(getHouseResponse,HttpStatus.OK);
    }

    @PutMapping("/api/v1/house")
    public ResponseEntity<UpdateHouseResponse> updateAddress(@RequestParam String houseId, @RequestBody String newAddress) {

        UpdateHouseResponse updateHouseResponse = houseService.updateAddress(Long.parseLong(houseId),newAddress);
        return new ResponseEntity<>(updateHouseResponse,HttpStatus.OK);
    }


    @GetMapping("/api/v1/house/{houseId}")
    public ResponseEntity<RoomsAndDevicesInHouse> getRoomsDevices(@PathVariable String houseId){
        RoomsAndDevicesInHouse roomsAndDevicesInHouse = houseService.getRoomsDevices(Long.parseLong(houseId));
        return new ResponseEntity<>(roomsAndDevicesInHouse,HttpStatus.OK);
    }
}










