package com.example.assessment2.dao;

import com.example.assessment2.entity.Booking;
import com.example.assessment2.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findTransaction(Integer bid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE transaction SET ticketsQuantity= :tickets WHERE bid = :bid", nativeQuery = true)
    int updatetransaction(@Param("tickets") int tickets, @Param("bid") Booking bid);

}
