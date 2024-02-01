package com.example.prashantjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "shift_users")
@Data
@AllArgsConstructor

public class ShiftUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.EAGER,cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "shift_id")
    private Shift shiftId;

    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.EAGER,cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "user_id")
    private User user;


}