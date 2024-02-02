package spring.assignment.assignment2.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.assignment.assignment2.dto.UserDto;
import spring.assignment.assignment2.mapper.UserMapper;
import spring.assignment.assignment2.models.Users;
import spring.assignment.assignment2.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserAuthService {
    private final UserRepository userRepo;
    private final UserMapper mapper;

    public Users getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Transactional
    public void register(UserDto userDto) {
        Users user = mapper.UserDtoToUser(userDto);
        userRepo.save(user);
    }
}
