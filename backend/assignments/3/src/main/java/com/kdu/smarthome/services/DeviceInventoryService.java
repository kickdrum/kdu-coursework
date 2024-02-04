package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddInventoryRequestDTO;
import com.kdu.smarthome.dto.response.AddInventoryResponseDTO;
import com.kdu.smarthome.dto.response.GetAllInventoryResponseDTO;
import com.kdu.smarthome.models.DeviceInventory;
import com.kdu.smarthome.repositories.HouseRepository;
import com.kdu.smarthome.repositories.DeviceInventoryRepository;
import com.kdu.smarthome.repositories.RoomsRepository;
import com.kdu.smarthome.repositories.UserRepository;
import com.kdu.smarthome.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeviceInventoryService {

    RoomsRepository roomsRepository;
    HouseRepository houseRepository;
    UserRepository userRepository;
    DeviceInventoryRepository inventoryRepository;

    @Autowired
    public DeviceInventoryService(HouseRepository houseRepository,
                                  UserRepository userRepository,
                                  RoomsRepository roomsRepository,
                                  DeviceInventoryRepository inventoryRepository){
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.roomsRepository = roomsRepository;
        this.inventoryRepository = inventoryRepository;
    }


    /**
     *
     * @param addInventoryRequestDTO
     * @return AddInventoryResponseDTO
     */
    public AddInventoryResponseDTO addInventory(AddInventoryRequestDTO addInventoryRequestDTO){

        // mapping DTO to Inventory
        DeviceInventory inventory = Mapper.getInventoryFromDTO(addInventoryRequestDTO);

        // saving inventory item
        DeviceInventory newInventory = inventoryRepository.save(inventory);

        return new AddInventoryResponseDTO("Inventory added successfully!!", newInventory.toString(), HttpStatus.OK);
    }


    /**
     *
     * @return GetAllInventoryResponseDTO
     */
    public GetAllInventoryResponseDTO getAllInventory(){

        // fetching all items from inventory
        List<DeviceInventory> inventoryList = inventoryRepository.findAll();

        // sending response
        String response = inventoryList.toString();
        return new GetAllInventoryResponseDTO(response, HttpStatus.OK);
    }





}
