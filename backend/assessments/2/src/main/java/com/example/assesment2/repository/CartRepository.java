package com.example.assesment2.repository;

import com.example.assesment2.entity.Cart;
import com.example.assesment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}