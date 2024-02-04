package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.Rooms;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomResponseDTO{

    @NotBlank(message = "message field should not be empty")
    String message;

    @NotBlank(message = "object room should not be empty")
    Rooms room;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}