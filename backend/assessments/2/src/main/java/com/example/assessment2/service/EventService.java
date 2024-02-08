package com.example.assessment2.service;

import com.example.assessment2.dao.EventRespository;
import com.example.assessment2.dto.EventDto;
import com.example.assessment2.entity.EventCatalog;
import com.example.assessment2.exception.custom.MyCustomException;
import com.example.assessment2.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class EventService {

    private static EventRespository eventRespository;

    @Autowired
    public EventService(EventRespository eventRespository){
        this.eventRespository = eventRespository;
    }

    public void addEvent(EventCatalog events){
        try {
            EventCatalog eventCatalog = eventRespository.save(events);
        }catch (Exception e){
            throw new MyCustomException("error while adding events");
        }
    }

    public EventDto findAllEvents(Pageable pageable){
        try {
            EventCatalog eventCatalog = eventRespository.findAll(pageable);
            return Mapper.convertToEventDto(eventCatalog);
        }catch (Exception e){
            throw new MyCustomException("error while adding events");
        }
    }
}
