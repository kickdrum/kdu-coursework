package org.example.dto;

import lombok.*;
import org.example.entity.Users;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddUserTOHouseResponse {
    private String message;
    private Users object;
    private HttpStatus httpStatus;
}
