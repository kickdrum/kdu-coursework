package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "order_id"
    )
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @OneToMany(mappedBy = "orderItemId")
    private List<OrderItem> orderItems;

    private LocalDate orderDate;
    private double totalAmount;
    private String shippingAddress;

}
