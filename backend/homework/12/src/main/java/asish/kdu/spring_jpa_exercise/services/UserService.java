package asish.kdu.spring_jpa_exercise.services;

import asish.kdu.spring_jpa_exercise.entities.User;
import asish.kdu.spring_jpa_exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user, String id) {
        userRepository.updateUserDetails(id, user.getUsername(), user.getLoggedin());
    }

    public Page<User> findAllUsers(int pageNumber, int pageSize) {
        pageNumber = Math.max(pageNumber, 0);
        pageSize = Math.min(Math.max(pageSize, 1), 50);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageRequest);
    }
}
