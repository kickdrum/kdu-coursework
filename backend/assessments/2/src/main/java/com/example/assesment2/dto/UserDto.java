package com.example.assesment2.dto;

import com.example.assesment2.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private List<Address> addresses;
}
