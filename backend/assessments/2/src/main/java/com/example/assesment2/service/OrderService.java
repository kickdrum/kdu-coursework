package com.example.assesment2.service;

import com.example.assesment2.entity.*;
import com.example.assesment2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartService cartService, UserService userService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.userService = userService;
    }

    public Orders placeOrder(String userEmail, String shippingAddress) {
        Users user = userService.getUserByEmail(userEmail);
        Cart cart = cartService.getOrCreateCart(userEmail);

        Orders newOrder = new Orders();
        newOrder.setUser(user);
        newOrder.setOrderItems(createOrderItems(cart.getProducts(), newOrder));
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalAmount(calculateTotalAmount(cart.getProducts()));
        newOrder.setShippingAddress(shippingAddress);

        cart.getProducts().clear();
        cartService.removeFromCart(userEmail, null);

        return orderRepository.save(newOrder);
    }

    private List<OrderItem> createOrderItems(List<Product> products, Orders order) {
        return products.stream()
                .map(product -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
//                    orderItem.setOrder(order);order
                    orderItem.setQuantity(1);
                    return orderItem;
                })
                .collect(Collectors.toList());
    }

    private double calculateTotalAmount(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
