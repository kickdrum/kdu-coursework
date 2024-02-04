package org.example.dao;


import org.example.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeviceDao extends JpaRepository<Device,Long> {
    @Query
    Optional<Device> findByKickstonId(String kickstonId);
}