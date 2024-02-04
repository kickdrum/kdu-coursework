package com.kdu.smarthome.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddHomeUserResponseDTO{

    @NotBlank(message = "message field should not be empty")
    String message;

    @NotBlank(message = "object field should not be empty")
    String object;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}
