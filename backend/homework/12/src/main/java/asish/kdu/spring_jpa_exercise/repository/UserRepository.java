package asish.kdu.spring_jpa_exercise.repository;

import asish.kdu.spring_jpa_exercise.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User getUserByUsername(String username);

    Page<User> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET username = :username, loggedin = :loggedin WHERE id = :uuid", nativeQuery = true)
    void updateUserDetails(@Param("uuid") String uuid, @Param("username") String username, @Param("loggedin") short loggedin);
}
