package com.kdu.smarthome.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInventoryResponseDTO{

    @NotBlank(message = "inventory should not be empty")
    String inventory;

    @NotBlank(message = "HTTP Status field should not be empty")
    HttpStatus httpStatus;
}