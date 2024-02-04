package com.kdu.smarthome.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "username field should not be empty")
    private String username;

    @NotBlank(message = "password field should not be empty")
    private String password;
}
