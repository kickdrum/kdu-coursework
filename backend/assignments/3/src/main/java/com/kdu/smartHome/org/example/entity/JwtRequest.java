package org.example.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Builder
@ToString
public class JwtRequest {

//    private String userId;
//    private String name;
    private String email;
    private String password;
//    private String role;

}
