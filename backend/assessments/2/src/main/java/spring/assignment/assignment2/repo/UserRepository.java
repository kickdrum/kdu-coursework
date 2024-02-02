package spring.assignment.assignment2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import spring.assignment.assignment2.dto.UserDto;
import spring.assignment.assignment2.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findById(long id);



}
