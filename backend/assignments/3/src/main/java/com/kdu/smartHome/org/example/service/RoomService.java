package org.example.service;


import org.example.dao.HouseDao;
import org.example.dao.RoomDao;
import org.example.dto.RoomRequest;
import org.example.dto.RoomResponse;
import org.example.entity.House;
import org.example.entity.Room;
import org.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private HouseDao houseDao;


    /**
     * Add a room to the particular house using houseId
     *
     * @param id
     * @param roomName
     * @return
     */
    public RoomResponse addRoom(Long id, String roomName) {
        RoomResponse roomResponse = new RoomResponse();
        Optional<House> optionalHouse = houseDao.findById(id);
        if (optionalHouse.isPresent()) {
            for (Room room : optionalHouse.get().getRooms()) {
                if (room.getRoomName().equals(roomName)) {
                    roomDao.save(room);
                    roomResponse.setRoom(room);
                    roomResponse.setMessage("room add to house successfully");
                    roomResponse.setHttpStatus(HttpStatus.OK);
                }
            }
        } else {
            roomResponse.setMessage("there is no such mapping");
        }
        return roomResponse;

    }

}