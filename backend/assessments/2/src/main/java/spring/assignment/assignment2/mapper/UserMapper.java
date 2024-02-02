package spring.assignment.assignment2.mapper;

import org.springframework.stereotype.Service;
import spring.assignment.assignment2.dto.UserDto;
import spring.assignment.assignment2.models.Users;

@Service
public class UserMapper {
    public Users UserDtoToUser(UserDto userDto) {
        Users user = new Users();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
