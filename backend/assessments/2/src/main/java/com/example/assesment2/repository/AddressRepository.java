package com.example.assesment2.repository;

import com.example.assesment2.entity.Address;
import com.example.assesment2.entity.Cart;
import com.example.assesment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
