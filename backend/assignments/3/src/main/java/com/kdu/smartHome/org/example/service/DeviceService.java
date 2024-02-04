package org.example.service;


import org.example.dao.DeviceDao;
import org.example.dao.HouseDao;
import org.example.dto.DeviceRequest;
import org.example.dto.DeviceResponse;
import org.example.entity.Device;
import org.example.entity.House;
import org.example.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DeviceService {


    @Autowired
    private DeviceDao deviceDao;


    @Autowired
    private HouseDao houseDao;


    public DeviceResponse addDevice(DeviceRequest deviceRequest) {
        DeviceResponse deviceResponse = new DeviceResponse();
        Optional<Device> optionalDevice = deviceDao.findByKickstonId(deviceRequest.getKickstonId());
        Optional<House> optionalHouse = houseDao.findById(Long.parseLong(deviceRequest.getHouseId()));

        if (optionalHouse.isPresent() && optionalDevice.isPresent()) {
            House house = optionalHouse.get();
            Device device = optionalDevice.get();

            Long roomId = Long.parseLong(deviceRequest.getRoomId());
            Optional<Room> optionalRoom = house.getRooms().stream()
                    .filter(room -> room.getId().equals(roomId))
                    .findFirst();

            if (optionalRoom.isPresent()) {
                Room room = optionalRoom.get();
                deviceDao.save(device);
                deviceResponse.setDevice(device);
                deviceResponse.setMessage("device added successfully");
                deviceResponse.setHttpStatus(HttpStatus.OK);
            }




        }
        return deviceResponse;
    }

}
