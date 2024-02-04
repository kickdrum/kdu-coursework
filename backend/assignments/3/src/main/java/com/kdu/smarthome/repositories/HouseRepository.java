package com.kdu.smarthome.repositories;

import com.kdu.smarthome.models.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
