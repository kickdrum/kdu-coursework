package com.example.assesment2.service;

import com.example.assesment2.entity.Cart;
import com.example.assesment2.entity.Product;
import com.example.assesment2.entity.Users;
import com.example.assesment2.repository.CartRepository;
import com.example.assesment2.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserService userService, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    public Cart getOrCreateCart(String userEmail) {
        Users user = userService.getUserByEmail(userEmail);
        return cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });
    }

    public Cart addToCart(String userEmail, Long productId, int quantity) {
        Cart cart = getOrCreateCart(userEmail);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }

    public void removeFromCart(String userEmail, Long productId) {
        Cart cart = getOrCreateCart(userEmail);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        cart.getProducts().remove(product);
        cartRepository.save(cart);
    }

    public List<Product> viewCart(String userEmail) {
        Cart cart = getOrCreateCart(userEmail);
        return cart.getProducts();
    }
}
