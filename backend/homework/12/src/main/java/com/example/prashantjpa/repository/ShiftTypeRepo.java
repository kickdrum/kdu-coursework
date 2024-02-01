package com.example.prashantjpa.repository;

import com.example.prashantjpa.entity.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ShiftTypeRepo extends JpaRepository<ShiftType, UUID> {
}