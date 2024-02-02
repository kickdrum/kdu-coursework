package spring.assignment.assignment2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDto {
    private String email;
    private String password;
}
