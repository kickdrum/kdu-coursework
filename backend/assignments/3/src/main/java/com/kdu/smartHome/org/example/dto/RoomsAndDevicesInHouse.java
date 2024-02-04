package org.example.dto;

import lombok.*;
import org.example.entity.Device;
import org.example.entity.House;
import org.example.entity.Room;
import org.springframework.http.HttpStatus;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomsAndDevicesInHouse {

    private String message;
    private List<Device> deviceList;
    private List<Room> roomList;

    private HttpStatus httpStatus;
}
