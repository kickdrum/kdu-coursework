package com.kdu.smarthome.dto.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddHouseRequestDTO {

    @NotBlank(message = "Address field should not be empty")
    @Size(min = 3, message = "Address field is too short")
    @Size(max = 100, message = "Address field is too long")
    String address;

    @NotBlank(message = "House name field should not be empty")
    @Size(min = 3, message = "House-name field is too short")
    @Size(max = 100, message = "House-name field is too long")
    String houseName;
}
