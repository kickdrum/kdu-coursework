package org.example.dto;

import lombok.*;
import org.example.entity.House;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class HouseResponse {
    private String message;
    private House house;
    private HttpStatus httpStatus;

    // getters and setters
}
