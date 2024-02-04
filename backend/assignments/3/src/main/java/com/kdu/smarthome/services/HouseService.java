package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddHomeUserRequestDTO;
import com.kdu.smarthome.dto.request.AddHouseRequestDTO;
import com.kdu.smarthome.dto.request.UpdateAddressRequestDTO;
import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repositories.HouseRepository;
import com.kdu.smarthome.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HouseService {

    HouseRepository houseRepository;
    UserRepository userRepository;

    public HouseService(HouseRepository houseRepository, UserRepository userRepository){
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }


    /**
     *
     * @param addHouseRequestDTO NOT NULL
     * @return AddHouseResponseDTO
     */
    public AddHouseResponseDTO addHouse(AddHouseRequestDTO addHouseRequestDTO){

        // getting username from JWT token
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("[HouseService - addHouse] username: " + username);

        // destructuring data from DTO
        String address = addHouseRequestDTO.getAddress();
        String houseName = addHouseRequestDTO.getHouseName();

        // fetching user from database
        Users users = userRepository.findByUsername(username);

        // adding house for corresponding user
        House house = new House(address, houseName, users);
        House newHouse = houseRepository.save(house);

        return new AddHouseResponseDTO("Home added successfully!!", newHouse, HttpStatus.OK);
    }

    /**
     *
     * @return GetAllHouseResponseDTO
     */
    public GetAllHouseResponseDTO getAllHouses(){

        // fetching all houses from database
        List<House> houseList = houseRepository.findAll();
        log.debug("[HouseService - getAllHouses] houseList: " + houseList);

        // converting list into string
        String houseListString = houseList.toString();

        return new GetAllHouseResponseDTO("All houses fetched successfully!!", houseListString, HttpStatus.OK);
    }


    /**
     *
     * @param id not null
     * @return GetAllDetailsResponseDTO
     */

    public GetAllDetailsResponseDTO getAllRoomsAndDevices(String id){

        // String --> Long conversion for HOUSE-ID
        Long houseId = Long.parseLong(id);

        // fetching house from database
        House house = houseRepository.findById(houseId).orElse(new House());

        // returning all rooms & devices details in response
        return new GetAllDetailsResponseDTO("Data fetched successfully!!",
                house.toString(),
                HttpStatus.OK);

    }


    /**
     *
     * @param id not null
     * @param updateAddressRequestDTO not null
     * @return UpdateAddressResponseDTO
     * @throws ResourceNotFoundException
     * @throws InvalidCredentialsException
     */
    public UpdateAddressResponseDTO updateAddress(String id, UpdateAddressRequestDTO updateAddressRequestDTO) throws ResourceNotFoundException, InvalidCredentialsException {

        // fetching username from JWT security context
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("updateAddress authenticatedUsername: " + authenticatedUsername);

        // fetching house object from database
        Long houseID = Long.parseLong(id);
        House house = houseRepository.findById(houseID).orElse(new House());

        // checking if house exists or not
        if(house.getHouseName() == null){
            throw new ResourceNotFoundException("House ID does not exists");
        }

        // updating house address
        String newAddress = updateAddressRequestDTO.getAddress();
        house.setAddress(newAddress);

        // saving house object in database
        House updatedHouse = houseRepository.save(house);

        return new UpdateAddressResponseDTO("House updated successfully!!",
                updatedHouse.toString(),
                HttpStatus.OK);

    }

    /**
     *
     * @param id
     * @param addHomeUserRequestDTO
     * @return
     * @throws ResourceNotFoundException
     * @throws InvalidCredentialsException
     */
    public AddHomeUserResponseDTO addHomeUser(String id, AddHomeUserRequestDTO addHomeUserRequestDTO) throws ResourceNotFoundException, InvalidCredentialsException {

        // fetching username from JWT security context
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("addHomeUser authenticatedUsername: " + authenticatedUsername);

        // destructuring request data
        String relativeUsername = addHomeUserRequestDTO.getUsername();
        Long houseID = Long.parseLong(id);

        // checking if house exist or not
        House house = houseRepository.findById(houseID).orElse(new House());

        if(house.getHouseName() == null){
            throw new ResourceNotFoundException("House ID does not exists");
        }

        // checking user to be added exists or not
        Users relativeUsersObject = userRepository.findByUsername(relativeUsername);

        if(relativeUsersObject==null || relativeUsersObject.getId() == null){
            throw new ResourceNotFoundException("Failed to add, User with given username does not exists");
        }

        // checking if authenticated user is admin or not
        String houseAdmin = house.getUsers().getUsername();

        if(!houseAdmin.equals(authenticatedUsername)){
            throw new InvalidCredentialsException("Only admin can add users");
        }

        // adding user in access list
        List<Users>usersList = house.getUserAccessList();
        usersList.add(relativeUsersObject);
        house.setUserAccessList(usersList);

        // saving house details in database
        House updatedHouse = houseRepository.save(house);

        return new AddHomeUserResponseDTO("User added successfully!!",
                updatedHouse.toString(),
                HttpStatus.OK);
    }
}
