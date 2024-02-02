package spring.assignment.assignment2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring.assignment.assignment2.util.UserRole;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
