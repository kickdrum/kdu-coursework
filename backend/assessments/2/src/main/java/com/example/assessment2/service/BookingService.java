package com.example.assessment2.service;

import com.example.assessment2.dao.BookingRepository;
import com.example.assessment2.dao.TransactionRepository;
import com.example.assessment2.entity.Booking;
import com.example.assessment2.exception.custom.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository,TransactionRepository transactionRepository){
        this.bookingRepository = bookingRepository;
        this.transactionRepository = transactionRepository;
    }

    public void cancelBooking(Booking bid) {
        bookingRepository.cancelBooking(bid);
        transactionRepository.updatetransaction(3,bid);
    }

    public void addBooking(Booking book){
        try {
             bookingRepository.save(book);

        }catch (Exception e){
            throw new MyCustomException("error while adding booking");
        }
    }
}
