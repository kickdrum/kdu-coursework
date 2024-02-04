package com.kdu.smarthome.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllHouseResponseDTO {

    @NotBlank(message = "message field should not be empty")
    String message;

    @NotBlank(message = "House list field should not be empty")
    String houses;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}
