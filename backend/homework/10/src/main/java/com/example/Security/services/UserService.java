package com.example.Security.services;

import com.example.Security.entity.User;
import com.example.Security.exceptions.CustomExp;
import com.example.Security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    UsersRepository userEntityRepository;


    @Autowired
    public UserService(UsersRepository userEntityRepository){
        this.userEntityRepository = userEntityRepository;
    }

    public void addPerson(User userEntity){
        userEntityRepository.addUserEntity(userEntity);
    }

    public List<User> getAll(){
        return userEntityRepository.getAllUserEntities();
    }
    public User getPersonUsername(String name){
        for(User u : userEntityRepository.getAllUserEntities()){
            if(u.getUserName().equalsIgnoreCase(name)){
                return u;
            }
        }

        throw new CustomExp("Invalid Username");
    }

}
