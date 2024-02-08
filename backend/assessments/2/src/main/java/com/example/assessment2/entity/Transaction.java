package com.example.assessment2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;

    @Column(name = "transaction_date")
    private String tranDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "event")
    private EventCatalog eventCatalog;

    @Column(name = "ticket_quantity")
    private int ticketsQuantity;
}
