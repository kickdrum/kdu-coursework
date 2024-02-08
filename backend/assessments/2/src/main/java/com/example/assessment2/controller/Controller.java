package com.example.assessment2.controller;


import com.example.assessment2.dto.EventDto;
import com.example.assessment2.entity.Booking;
import com.example.assessment2.exception.custom.MyCustomException;
import com.example.assessment2.mapper.Mapper;
import com.example.assessment2.service.BookingService;
import com.example.assessment2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    EventService eventService;

    BookingService bookingService;

    @Autowired
    public Controller(EventService eventService,BookingService bookingService) {
        this.eventService = eventService;
        this.bookingService = bookingService;
    }


    @GetMapping("/events/view")
    public ResponseEntity<Page<EventDto>> displayEvents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "50") int size) {

            if (page < 0) {
                page = 0;
            }

            if (size < 1 || size > 50) {
                size = 50;
            }
            Pageable pageable = PageRequest.of(page, size);
            Page<EventDto> usersPage = (Page<EventDto>) eventService.findAllEvents((java.awt.print.Pageable) pageable);

            return ResponseEntity.ok(usersPage);
    }
    @PostMapping("/events/add")
    public ResponseEntity<String> addEvents(@RequestBody EventDto event){
        eventService.addEvent(Mapper.convertToEvent(event));
        return ResponseEntity.ok("Event Added");
    }

    @PostMapping("/events/reserve")
    public ResponseEntity<String> addEvents(@RequestBody Booking booking){
        bookingService.addBooking(booking);
        return ResponseEntity.ok("Reserved");
    }

    @DeleteMapping("/events/cancel/{bid}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable Booking bid) throws MyCustomException {
        bookingService.cancelBooking(bid);
        return ResponseEntity.ok("Booking canceled successfully");
    }
}
