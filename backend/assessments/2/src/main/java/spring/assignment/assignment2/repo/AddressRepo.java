package spring.assignment.assignment2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.assignment.assignment2.models.Address;

import java.util.Set;

public interface AddressRepo extends JpaRepository<Address,Long> {

    Set<Address> findByUserId(long userId);
}
