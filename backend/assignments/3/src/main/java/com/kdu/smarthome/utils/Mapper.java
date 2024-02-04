package com.kdu.smarthome.utils;

import com.kdu.smarthome.dto.request.AddInventoryRequestDTO;
import com.kdu.smarthome.dto.request.RegisterRequesDTO;
import com.kdu.smarthome.models.DeviceInventory;
import com.kdu.smarthome.models.Users;

public class Mapper {

    private Mapper(){}

    /**
     * Mapper to map RegisterDTO --> User obejct
     * @param registerRequesDTO
     * @return
     */
    public static Users getUserFromRegisterDTO(RegisterRequesDTO registerRequesDTO){

        return new Users(
                registerRequesDTO.getUsername(),
                registerRequesDTO.getPassword(),
                registerRequesDTO.getName(),
                registerRequesDTO.getFirstName(),
                registerRequesDTO.getLastName(),
                registerRequesDTO.getEmailId()
        );
    }

    /**
     * Mapper to map AddInventoryDTO --> DeviceInventory Object
     *
     * @param addInventoryRequestDTO
     * @return
     */
    public static DeviceInventory getInventoryFromDTO(AddInventoryRequestDTO addInventoryRequestDTO){

        return new DeviceInventory(
                addInventoryRequestDTO.getKickstonId(),
                addInventoryRequestDTO.getDeviceUsername(),
                addInventoryRequestDTO.getDevicePassword(),
                addInventoryRequestDTO.getManufactureDateTime(),
                addInventoryRequestDTO.getManufactureFactoryPlace()
        );
    }



}
