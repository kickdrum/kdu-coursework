package org.example.dto;

import lombok.*;
import org.example.dao.RoomDao;
import org.springframework.http.HttpStatus;
import org.example.entity.Room;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomResponse {
    private String message;
    private Room room;
    HttpStatus httpStatus;
}
