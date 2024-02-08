package com.example.assessment2.service;

import com.example.assessment2.dao.TransactionRepository;
import com.example.assessment2.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository= transactionRepository;
    }
    void updateTickets(int tickets, Booking bid){
        transactionRepository.updatetransaction(tickets,bid);
    }
}
