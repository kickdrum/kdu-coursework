package com.example.prashantjdbc.service;
import com.example.prashantjdbc.dto.UserDto;
import com.example.prashantjdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(UserDto userDTO) {
        userDao.saveUser(userDTO);
    }
}
