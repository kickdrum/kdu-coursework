package com.kdu.smarthome.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDeviceRequestDTO {

    @NotBlank(message = "kickstonId field should not be empty")
    private String kickstonId;

    @NotBlank(message = "device_username field should not be empty")
    private String deviceUsername;

    @NotBlank(message = "device_password field should not be empty")
    private String devicePassword;
}