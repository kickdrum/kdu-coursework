package com.example.assesment2.controller;

import com.example.assesment2.entity.Orders;
import com.example.assesment2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{email}/{shippingAddress}")
    public ResponseEntity<?> placeOrder(@PathVariable String email, @PathVariable String shippingAddress) {
        Orders newOrder = orderService.placeOrder(email, shippingAddress);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}
