package com.example.assesment2.controller;

import com.example.assesment2.entity.Cart;
import com.example.assesment2.entity.Product;
import com.example.assesment2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> viewCart(@PathVariable String email) {
        List<Product> cartItems = cartService.viewCart(email);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/{email}/{productId}/{quantity}")
    public ResponseEntity<?> addToCart(@PathVariable String email, @PathVariable Long productId, @PathVariable int quantity) {
        Cart updatedCart = cartService.addToCart(email, productId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{email}/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable String email, @PathVariable Long productId) {
        cartService.removeFromCart(email, productId);
        return ResponseEntity.ok("Item removed from cart");
    }
}
