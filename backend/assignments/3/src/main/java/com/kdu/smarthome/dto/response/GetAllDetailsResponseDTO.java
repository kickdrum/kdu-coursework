package com.kdu.smarthome.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDetailsResponseDTO {

    @NotBlank(message = "message field should not be empty")
    String message;

    @NotBlank(message = "object room should not be empty")
    String roomsAndDevices;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}