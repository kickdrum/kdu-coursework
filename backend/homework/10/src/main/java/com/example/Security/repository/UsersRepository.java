package com.example.Security.repository;

import com.example.Security.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UsersRepository {
    List<User> userEntityList;

    public  UsersRepository() {
        this.userEntityList = new ArrayList<>();
    }

    public void addUserEntity(User userEntity){
        userEntityList.add(userEntity);
    }

    public List<User> getAllUserEntities(){
        return userEntityList;
    }
}
