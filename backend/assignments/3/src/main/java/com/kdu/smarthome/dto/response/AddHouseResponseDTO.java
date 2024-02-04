package com.kdu.smarthome.dto.response;


import com.kdu.smarthome.models.House;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddHouseResponseDTO {

    @NotBlank(message = "message field should not be empty")
    String message;

    @NotBlank(message = "House object field should not be empty")
    House house;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}
