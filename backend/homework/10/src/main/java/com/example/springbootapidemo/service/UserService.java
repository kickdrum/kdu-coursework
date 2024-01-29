package com.example.springbootapidemo.service;

import com.example.springbootapidemo.dto.request.UserReqDTO;
import com.example.springbootapidemo.dto.response.UserDTO;
import com.example.springbootapidemo.model.User;
import com.example.springbootapidemo.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.example.springbootapidemo.repository.Database.userList;

@Service
@Slf4j
public class UserService {

    /**
     *
     * @param userReqDTO
     */
    public void addUser(UserReqDTO userReqDTO){
        User user = Mapper.getUserFromDto(userReqDTO);
        userList.add(user);
    }

    /**
     *
     * @param userName
     * @return
     */
    public UserDTO getUser(String userName){

        for(User user: userList){
            if(user.getUserName().equals(userName)){
                return Mapper.userToUserDTO(user);
            }
        }

        return new UserDTO();
    }

    /**
     *
     * @return
     */
    public List<UserDTO> getList(){
        return Mapper.userListToUserDTO(userList);
    }

}
