package com.example.springbootapidemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDTO {
    private String userName;
    private String password;
    private String email;
}

