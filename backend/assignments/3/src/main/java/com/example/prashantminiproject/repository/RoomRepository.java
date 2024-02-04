package com.example.prashantminiproject.repository;

import com.example.prashantminiproject.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<Room, Long> {

}
