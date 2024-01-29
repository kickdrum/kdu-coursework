package com.example.springbootapidemo.repository;

import com.example.springbootapidemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private Database(){}

    public static final List<User> userList = new ArrayList<>();

}
