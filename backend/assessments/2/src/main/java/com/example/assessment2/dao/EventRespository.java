package com.example.assessment2.dao;

import com.example.assessment2.entity.EventCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface EventRespository extends JpaRepository<EventCatalog,Integer> {

    List<EventCatalog> findEvents(Integer eid);
    EventCatalog findAll(Pageable pageable);
}
