package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddDeviceRequestDTO;
import com.kdu.smarthome.dto.request.MoveDeviceRequestDTO;
import com.kdu.smarthome.dto.request.RegisterDeviceRequestDTO;
import com.kdu.smarthome.dto.response.AddDeviceResponseDTO;
import com.kdu.smarthome.dto.response.RegisterDeviceResponseDTO;
import com.kdu.smarthome.exceptions.custom.InvalidCredentialsException;
import com.kdu.smarthome.exceptions.custom.InvalidDeviceCredentialsException;
import com.kdu.smarthome.exceptions.custom.ResourceNotFoundException;
import com.kdu.smarthome.models.DeviceInventory;
import com.kdu.smarthome.models.Devices;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.models.Rooms;
import com.kdu.smarthome.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeviceService {

    RoomsRepository roomsRepository;
    HouseRepository houseRepository;
    UserRepository userRepository;
    DeviceInventoryRepository inventoryRepository;
    DeviceRepository deviceRepository;

    public DeviceService(HouseRepository houseRepository,
                         UserRepository userRepository,
                         RoomsRepository roomsRepository,
                         DeviceInventoryRepository inventoryRepository,
                         DeviceRepository deviceRepository){
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.roomsRepository = roomsRepository;
        this.inventoryRepository = inventoryRepository;
        this.deviceRepository = deviceRepository;
    }


    /**
     *
     * @param registerDeviceRequestDTO
     * @return RegisterDeviceResponseDTO
     * @throws InvalidCredentialsException
     * @throws ResourceNotFoundException
     * @throws InvalidDeviceCredentialsException
     */
    public RegisterDeviceResponseDTO registerDevice(RegisterDeviceRequestDTO registerDeviceRequestDTO) throws InvalidCredentialsException, ResourceNotFoundException, InvalidDeviceCredentialsException {

        // loading authenticated user's credentials
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("registerDevice - authenticatedUsername: " + authenticatedUsername);


        // requested credentials
        String kickstonId = registerDeviceRequestDTO.getKickstonId();
        String deviceUsername = registerDeviceRequestDTO.getDeviceUsername();
        String devicePassword = registerDeviceRequestDTO.getDevicePassword();


        // checking if it is available to register
        Devices history = deviceRepository.findDeviceByKickstonId(kickstonId);

        if((history!=null ) && (history.getUsername()!=null)){
            throw new ResourceNotFoundException("This device is already registered");
        }


        // fetching object from inventory
        DeviceInventory deviceInventory = inventoryRepository.findDeviceInventoryByKickStoneId(kickstonId);


        // verifying credentials
        String actualKickstonId = deviceInventory.getKickStoneId();
        String actualDeviceUsername = deviceInventory.getDeviceUserName();
        String actualDevicePassword = deviceInventory.getDevicePassword();

        if(!actualKickstonId.equals(kickstonId) ||
                !actualDeviceUsername.equals(deviceUsername) ||
                !actualDevicePassword.equals(devicePassword)){
            throw new InvalidDeviceCredentialsException("Invalid Credentials");
        }

        // saving device
        Devices devices = new Devices(kickstonId, authenticatedUsername, deviceUsername);
        Devices newDevice = deviceRepository.save(devices);

        return new RegisterDeviceResponseDTO("Device registered successfully!!", newDevice.toString(), HttpStatus.OK);

    }

    /**
     *
     * @param addDeviceRequestDTO
     * @return AddDeviceResponseDTO
     * @throws InvalidDeviceCredentialsException
     * @throws InvalidCredentialsException
     */
    public AddDeviceResponseDTO addDevice(AddDeviceRequestDTO addDeviceRequestDTO) throws InvalidDeviceCredentialsException, InvalidCredentialsException {


        // loading authenticated user's credentials
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("registerDevice - authenticatedUsername: " + authenticatedUsername);


        // requested credentials
        String kickstonId = addDeviceRequestDTO.getKickstonId();
        String roomId = addDeviceRequestDTO.getRoomId();
        String houseId = addDeviceRequestDTO.getHouseId();

        // fetching device details using kickston id
        Devices devices = deviceRepository.findDeviceByKickstonId(kickstonId);

        if(devices == null || devices.getUsername() == null){
            throw new InvalidDeviceCredentialsException("Device not registered");
        }

        // checking user validity
        if(!devices.getUsername().equals(authenticatedUsername)){
            throw new InvalidCredentialsException("Only owner can add devices!!");
        }


        // verifying room id
        Long roomID = Long.parseLong(roomId);
        Rooms rooms = roomsRepository.findById(roomID).orElse(new Rooms());

        if(rooms.getRoomName().isEmpty()){
            throw new InvalidDeviceCredentialsException("Invalid room!!");
        }


        // verifying room id
        Long houseID = Long.parseLong(houseId);
        House house = houseRepository.findById(houseID).orElse(new House());

        if(house.getHouseName().isEmpty()){
            throw new InvalidDeviceCredentialsException("Invalid House!!");
        }

        // checking if house belongs to authenticated user or not
        if(!house.getUsers().getUsername().equals(authenticatedUsername)){
            throw new InvalidCredentialsException("Only owner can add devices!!");
        }


        // checking if room is present in house or not
        if(!house.getRoomsList().contains(rooms)){
            throw new InvalidDeviceCredentialsException("Invalid house and rooms!!");
        }


        // adding house to device
        String roomName = rooms.getRoomName();
        devices.setRoomName(roomName);
        Devices updatedDevice = deviceRepository.save(devices);

        // adding device in house's device list
        List<Devices> devicesList = house.getDevices();
        devicesList.add(updatedDevice);
        house.setDevices(devicesList);

        House updatedHouse = houseRepository.save(house);

        return new AddDeviceResponseDTO("Device installed successfully!!",
                updatedHouse.toString(),
                HttpStatus.OK);
    }


    /**
     *
     * @param moveDeviceRequestDTO
     */
    public void moveDevice(MoveDeviceRequestDTO moveDeviceRequestDTO) throws InvalidDeviceCredentialsException {

        // destructuring data
        String deviceId = moveDeviceRequestDTO.getDeviceId();
        String roomId = moveDeviceRequestDTO.getRoomId();

        Long dId = Long.parseLong(deviceId);
        Long rId = Long.parseLong(roomId);


        // fetching room and device from database
        Devices devices = deviceRepository.findById(dId).orElse(new Devices());
        Rooms rooms = roomsRepository.findById(rId).orElse(new Rooms());

        // verifying room and device
        if(devices.getDeviceUsername().isEmpty()){
            throw new InvalidDeviceCredentialsException("Invalid device!!");
        }

        if(rooms.getRoomName().isEmpty()){
            throw new InvalidDeviceCredentialsException("Invalid room!!");
        }

        // updating room name
        String roomName = rooms.getRoomName();
        devices.setRoomName(roomName);
        deviceRepository.save(devices);


    }

}
