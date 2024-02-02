package com.example.assesment2.dto;

import com.example.assesment2.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {
//    street city state postalCode nickname user
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String nickname;
    private Users user;
}
