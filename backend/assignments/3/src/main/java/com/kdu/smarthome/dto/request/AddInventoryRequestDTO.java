package com.kdu.smarthome.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryRequestDTO {

    @NotBlank(message = "kickstonId field should not be empty")
    private String kickstonId;

    @NotBlank(message = "device_username field should not be empty")
    private String deviceUsername;

    @NotBlank(message = "device_password field should not be empty")
    private String devicePassword;

    @NotBlank(message = "manufacture_date_time field should not be empty")
    private String manufactureDateTime;

    @NotBlank(message = "manufacture_factory_place field should not be empty")
    private String manufactureFactoryPlace;

}