package org.example.dto;

import lombok.*;
import org.example.entity.House;
import org.springframework.http.HttpStatus;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetHouseResponse {
    String message;
    List<House> houseList;
    HttpStatus httpStatus;
}
