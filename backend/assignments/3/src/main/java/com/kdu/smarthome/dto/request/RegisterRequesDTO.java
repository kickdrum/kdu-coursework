package com.kdu.smarthome.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequesDTO {

    @NotBlank(message = "name field should not be empty")
    private String name;

    @NotBlank(message = "username field should not be empty")
    private String username;

    @NotBlank(message = "password field should not be empty")
    private String password;

    @NotBlank(message = "firstName field should not be empty")
    private String firstName;

    @NotBlank(message = "lastName field should not be empty")
    private String lastName;

    @Email(message = "emailId field should not be empty")
    private String emailId;
}
