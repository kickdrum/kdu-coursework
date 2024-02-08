package com.example.assessment2.mapper;

import com.example.assessment2.dto.EventDto;
import com.example.assessment2.entity.EventCatalog;

public class Mapper {
    public static EventDto convertToEventDto(EventCatalog events){
        return new EventDto(events.getEid(), events.getName(), events.getDate(), events.getVenue(), events.getTickets());
    }

    public static EventCatalog convertToEvent(EventDto events){
        return new EventCatalog(events.getEid(), events.getName(), events.getDate(), events.getVenue(), events.getTickets());
    }
}
