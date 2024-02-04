package org.example.dao;

import org.example.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseDao extends JpaRepository<House,Long> {
}
