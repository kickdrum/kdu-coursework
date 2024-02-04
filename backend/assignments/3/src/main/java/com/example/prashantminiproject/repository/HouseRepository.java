package com.example.prashantminiproject.repository;

import com.example.prashantminiproject.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Modifying
    @Transactional
    @Query("update House h set h.address = ?1, h.houseName = ?2 where h.houseId = ?3")
    void setHouseInfoById(String address, String houseName, Long houseId);
}
