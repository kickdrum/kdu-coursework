package com.kdu.smarthome.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceRequestDTO {

    @NotBlank(message = "houseId field should not be empty")
    private String houseId;

    @NotBlank(message = "roomId field should not be empty")
    private String roomId;

    @NotBlank(message = "kickstonId field should not be empty")
    private String kickstonId;
}