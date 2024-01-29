package com.example.springbootapidemo.utils;

import com.example.springbootapidemo.dto.request.UserReqDTO;
import com.example.springbootapidemo.dto.response.UserDTO;
import com.example.springbootapidemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private Mapper(){}

    /**
     *
     * @param user
     * @return
     */
    public static UserDTO userToUserDTO(User user){
        return new UserDTO(user.getUserName(), user.getEmail());
    }

    /**
     *
     * @param userList
     * @return
     */
    public static List<UserDTO> userListToUserDTO(List<User> userList){
        List<UserDTO> response = new ArrayList<>();

        for(User user: userList){
            UserDTO userDTO = userToUserDTO(user);
            response.add(userDTO);
        }
        return response;
    }

    /**
     *
     * @param userReqDTO
     * @return
     */
    public static User getUserFromDto(UserReqDTO userReqDTO){
        return new User(
                userReqDTO.getUserName(),
                userReqDTO.getPassword(),
                userReqDTO.getEmail()
        );
    }
}
