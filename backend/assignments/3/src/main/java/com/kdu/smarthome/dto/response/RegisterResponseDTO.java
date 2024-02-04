package com.kdu.smarthome.dto.response;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {

    @NotBlank(message = "username field cannot be empty")
    private String username;

    @NotBlank(message = "token field cannot be empty")
    private String token;
}
