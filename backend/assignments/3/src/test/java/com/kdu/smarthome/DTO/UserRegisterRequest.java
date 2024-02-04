package com.kdu.smarthome.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterRequest {

    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

}

