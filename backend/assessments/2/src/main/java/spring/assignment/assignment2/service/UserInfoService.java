package spring.assignment.assignment2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.assignment.assignment2.mapper.UserMapper;
import spring.assignment.assignment2.models.Address;
import spring.assignment.assignment2.models.Users;
import spring.assignment.assignment2.repo.AddressRepo;
import spring.assignment.assignment2.repo.UserRepository;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserRepository userRepo;
    private final AddressRepo addressRepo;
    private final UserMapper mapper;

    public Users getUserDetails(String email) {
        return userRepo.findByEmail(email);
    }

    public Set<Address> getUserAddress(String email) {
        Users user = userRepo.findByEmail(email);
        return addressRepo.findByUserId(user.getUserId());
    }
}
