package com.example.prashantminiproject.repository;

import com.example.prashantminiproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    User findByUsername(String username);

    @Query
    User findByToken(String token);

}