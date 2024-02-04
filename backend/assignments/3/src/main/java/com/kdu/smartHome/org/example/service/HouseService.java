package org.example.service;

import org.example.dao.HouseDao;
import org.example.dao.UsersDao;
import org.example.dto.*;
import org.example.entity.Device;
import org.example.entity.House;
import org.example.entity.Room;
import org.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private HouseDao houseDao;

    @Autowired
    UsersDao usersDao;

    public HouseResponse addHouse(HouseRequest houseRequest) {
        House newHouse = new House();
        newHouse.setAddress(houseRequest.getAddress());
        newHouse.setHouseName(houseRequest.getHouseName());

        houseDao.save(newHouse);
        HouseResponse houseResponse=new HouseResponse();
        houseResponse.setHouse(newHouse);
        houseResponse.setMessage("A new house created successfully");
        houseResponse.setHttpStatus(HttpStatus.OK);
        return houseResponse;
    }




        public AddUserTOHouseResponse addUser(Long id, AddUserToHouseRequest addUserToHouseRequest){
            Users users = usersDao.findByUsername(addUserToHouseRequest.getUsername()).orElse(null);
            if(users!=null){
                House house=houseDao.findById(id).orElse(null);
                List<Users> usersList=house.getUsersList();
                usersList.add(users);
                house.setUsersList(usersList);
            }



             AddUserTOHouseResponse addUserTOHouseResponse=new AddUserTOHouseResponse();
             addUserTOHouseResponse.setObject(users);
             addUserTOHouseResponse.setMessage("user added to house successfully");
            addUserTOHouseResponse.setHttpStatus(HttpStatus.OK);
             return addUserTOHouseResponse;
        }


    public GetHouseResponse getAll(){
        List<House> houseList = houseDao.findAll();
        GetHouseResponse getHouseResponse=new GetHouseResponse();
        getHouseResponse.setHouseList(houseList);
        getHouseResponse.setMessage("List of houses returned");
        getHouseResponse.setHttpStatus(HttpStatus.OK);
        return getHouseResponse;
    }

    public UpdateHouseResponse updateAddress(Long id, String newAddress){
        Optional<House> optHouse = houseDao.findById(id);

            House house = optHouse.get();
            house.setAddress(newAddress);
            houseDao.save(house);


        UpdateHouseResponse  updateHouseResponse=new UpdateHouseResponse();
        updateHouseResponse.setHouse(house);
        updateHouseResponse.setMessage("house updated successfully");
        updateHouseResponse.setHttpStatus(HttpStatus.OK);


        return updateHouseResponse;


    }

    public RoomsAndDevicesInHouse getRoomsDevices(Long id) {
        Optional<House> optionalHouse = houseDao.findById(id);

            House house = optionalHouse.get();
            List<Room> rooms = house.getRooms();
            List<Device> devices = new ArrayList<>();
            for(Room room : rooms){
                List<Device> deviceList = room.getDeviceList();
                devices.addAll(deviceList);
            }
            RoomsAndDevicesInHouse roomsAndDevicesInHouse=new RoomsAndDevicesInHouse();
            roomsAndDevicesInHouse.setRoomList(rooms);
            roomsAndDevicesInHouse.setDeviceList(devices);
            roomsAndDevicesInHouse.setMessage("Rooms and devices retrieved successfully");
            roomsAndDevicesInHouse.setHttpStatus(HttpStatus.OK);
            return roomsAndDevicesInHouse;



    }










}































//
//
//
//
//package com.kdu.smarthome.services;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.kdu.smarthome.dto.*;
//        import com.kdu.smarthome.dto.house.HouseListDTO;
//import com.kdu.smarthome.dto.house.HouseRequestDTO;
//import com.kdu.smarthome.dto.house.HouseResponseDTO;
//import com.kdu.smarthome.dto.room.RoomsDevicesDTO;
//import com.kdu.smarthome.entity.Device;
//import com.kdu.smarthome.entity.House;
//import com.kdu.smarthome.entity.Room;
//import com.kdu.smarthome.entity.UserModel;
//import com.kdu.smarthome.exceptions.NotAuthorizedException;
//import com.kdu.smarthome.exceptions.NotFoundException;
//import com.kdu.smarthome.exceptions.UserNotAdminException;
//import com.kdu.smarthome.mapping.HouseMapping;
//import com.kdu.smarthome.repository.HouseRepository;
//import com.kdu.smarthome.repository.UserRepository;
//import com.kdu.smarthome.utils.JSONUtil;
//import com.kdu.smarthome.utils.JWTUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class HouseService {
//    private final HouseRepository houseRepository;
//    private final UserRepository userRepository;
//    private final JWTUtil jwtUtil;
//    private final HouseMapping houseMapping;
//    private final JSONUtil jsonUtil;
//
//    @Autowired
//    public HouseService(HouseRepository houseRepository,
//                        UserRepository userRepository,
//                        JWTUtil jwtUtil,
//                        HouseMapping houseMapping,
//                        JSONUtil jsonUtil) {
//        this.houseRepository = houseRepository;
//        this.userRepository = userRepository;
//        this.jwtUtil = jwtUtil;
//        this.houseMapping = houseMapping;
//        this.jsonUtil = jsonUtil;
//    }
//
//    public HouseResponseDTO addHouse(HouseRequestDTO houseRequestDTO, String token){
//        String username = jwtUtil.decodeToken(token);
//        Optional<UserModel> optionalUser = userRepository.findByUsername(username);
//        if(optionalUser.isEmpty())
//            throw new NotFoundException("User not found");
//
//        UserModel user = optionalUser.get();
//        user.setRole("ROLE_ADMIN");
//        House house = houseMapping.houseMapping(houseRequestDTO,user);
//        userRepository.save(user);
//        houseRepository.save(house);
//        return new HouseResponseDTO("House added successfully!",house, HttpStatus.OK);
//    }
//
//    public ResponseInfoDTO addUser(Long id, String username, String token){
//        String userAdmin = jwtUtil.decodeToken(token);
//        Optional<UserModel> optionalUser = userRepository.findByUsername(userAdmin);
//        if(optionalUser.isEmpty())
//            throw new NotAuthorizedException("User Not found");
//
//        UserModel user = optionalUser.get();
//        if(user.getRole().equals("ROLE_ADMIN")){
//            Optional<House> optionalHouse = houseRepository.findById(id);
//            if(optionalHouse.isPresent()){
//                House house = optionalHouse.get();
//                Optional<UserModel> optionalUserModel = userRepository.findByUsername(username);
//                if(optionalUserModel.isEmpty())
//                    throw new NotAuthorizedException("User Not found");
//
//
//                house.getUsersList().add(optionalUserModel.get());
//                return new ResponseInfoDTO("User added successfully!","Username : ".concat(username),HttpStatus.OK);
//            }
//            else {
//                throw new NotFoundException("House with given id not found");
//            }
//        }
//        else{
//            throw new UserNotAdminException("Given user is not admin!");
//        }
//    }
//
//    public HouseListDTO getAll() throws JsonProcessingException {
//        List<House> houseList = houseRepository.findAll();
//        String houses = jsonUtil.convertListToJSONString(houseList);
//        return new HouseListDTO("Fetched Successfully!",houses,HttpStatus.OK);
//    }
//
//    public ResponseInfoDTO updateAddress(Long id, String newAddress){
//        Optional<House> optHouse = houseRepository.findById(id);
//        if(optHouse.isPresent()){
//            House house = optHouse.get();
//            house.setAddress(newAddress);
//            houseRepository.save(house);
//            return new ResponseInfoDTO("House updated successfully!","New Address : ".concat(newAddress),HttpStatus.OK);
//        }
//        else{
//            throw new NotFoundException("House with given id not found");
//        }
//    }
//
//    public RoomsDevicesDTO getRoomsDevices(Long id) throws JsonProcessingException {
//        Optional<House> optionalHouse = houseRepository.findById(id);
//        if(optionalHouse.isPresent()){
//            House house = optionalHouse.get();
//            List<Room> rooms = house.getRooms();
//            List<Device> devices = new ArrayList<>();
//            for(Room room : rooms){
//                List<Device> deviceList = room.getDeviceList();
//                devices.addAll(deviceList);
//            }
//            TempRespDTO tempRespDTO = new TempRespDTO(house,rooms,devices);
//            String roomsDevices = jsonUtil.convertObjToJSONString(tempRespDTO);
//            return new RoomsDevicesDTO("Fetched successfully!",roomsDevices,HttpStatus.OK);
//        }
//        else{
//            throw new NotFoundException("House with given id not found!");
//        }
//
//    }
//}
//
//

