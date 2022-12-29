package com.example.mockito.dao;

import com.example.mockito.model.User;

import java.util.List;

public interface UserDao <user> {

    User getUserByName(String name);

    List<User> findAllUsers();
}
