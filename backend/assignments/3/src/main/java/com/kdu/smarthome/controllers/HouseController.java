package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddHomeUserRequestDTO;
import com.kdu.smarthome.dto.request.AddHouseRequestDTO;
import com.kdu.smarthome.dto.request.UpdateAddressRequestDTO;
import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.services.HouseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/house")
@Slf4j
public class HouseController {

    HouseService houseService;

    public HouseController(HouseService houseService){
        this.houseService = houseService;
    }


    /**
     *
     * @param addHouseRequestDTO
     * @return AddHouseResponseDTO
     */
    @PostMapping()
    public ResponseEntity<AddHouseResponseDTO> addHouse(@Valid @RequestBody AddHouseRequestDTO addHouseRequestDTO){

        log.info("POST: /api/v1/house");
        log.debug(addHouseRequestDTO.toString());

        AddHouseResponseDTO addHouseResponseDTO = houseService.addHouse(addHouseRequestDTO);
        return new ResponseEntity<>(addHouseResponseDTO, HttpStatus.OK);
    }

    /**
     *
     * @return GetAllHouseResponseDTO
     */
    @GetMapping()
    public ResponseEntity<GetAllHouseResponseDTO> addHouse(){

        log.info("GET: /api/v1/house");

        GetAllHouseResponseDTO getAllHouseResponseDTO = houseService.getAllHouses();
        return new ResponseEntity<>(getAllHouseResponseDTO, HttpStatus.OK);
    }


    /**
     *
     * @param houseId
     * @return GetAllDetailsResponseDTO
     */
    @GetMapping("/{houseId}")
    public ResponseEntity<GetAllDetailsResponseDTO> getAllrooms(@PathVariable String houseId){

        log.info("GET: /api/v1/house/{houseId}");
        log.debug(houseId);

        GetAllDetailsResponseDTO getAllHouseResponseDTO = houseService.getAllRoomsAndDevices(houseId);
        return new ResponseEntity<>(getAllHouseResponseDTO, HttpStatus.OK);
    }

    /**
     *
     * @param houseId
     * @param updateAddressRequestDTO
     * @return UpdateAddressResponseDTO
     * @throws InvalidCredentialsException
     * @throws ResourceNotFoundException
     */
    @PutMapping()
    public ResponseEntity<UpdateAddressResponseDTO> updateAddress(@RequestParam String houseId,
                                                                  @RequestBody UpdateAddressRequestDTO updateAddressRequestDTO) throws InvalidCredentialsException, ResourceNotFoundException {

        log.info("PUT: /api/v1/house");
        log.debug(houseId + " & " + updateAddressRequestDTO);

        UpdateAddressResponseDTO updateAddressResponseDTO = houseService.updateAddress(houseId, updateAddressRequestDTO);
        return new ResponseEntity<>(updateAddressResponseDTO, HttpStatus.OK);
    }


    /**
     *
     * @param houseId
     * @param addHomeUserRequestDTO
     * @return
     * @throws InvalidCredentialsException
     * @throws ResourceNotFoundException
     */

    @PostMapping("/{houseId}/add-user")
    public ResponseEntity<AddHomeUserResponseDTO> addUserToHouse(@Valid @PathVariable String houseId,
                                               @RequestBody AddHomeUserRequestDTO addHomeUserRequestDTO
                                               ) throws InvalidCredentialsException, ResourceNotFoundException {

        log.info("POST: /api/v1/{houseId}/add-user");
        log.debug(houseId + " & " + addHomeUserRequestDTO);

        AddHomeUserResponseDTO addHomeUserResponseDTO = houseService.addHomeUser(houseId, addHomeUserRequestDTO);
        return new ResponseEntity<>(addHomeUserResponseDTO, HttpStatus.OK);
    }


}