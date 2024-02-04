package com.kdu.smarthome.repositories;

import com.kdu.smarthome.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
}
