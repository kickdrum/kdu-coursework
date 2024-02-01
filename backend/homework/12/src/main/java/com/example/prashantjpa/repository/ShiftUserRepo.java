package com.example.prashantjpa.repository;

import com.example.prashantjpa.entity.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface ShiftUserRepo extends JpaRepository<ShiftUser, Long> {
    @Transactional
    void deleteByUser_Id(UUID userId);
}