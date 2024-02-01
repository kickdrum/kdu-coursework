package com.example.prashantjpa.repository;

import com.example.prashantjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    Page<User> findAll(Pageable pageable);
    @Modifying
    @Query(value = "UPDATE users SET username = :username WHERE id = :userId", nativeQuery = true)
    int updateUserUsername(UUID userId);
}
