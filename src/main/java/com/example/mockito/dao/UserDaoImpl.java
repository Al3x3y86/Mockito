package com.example.mockito.dao;


import com.example.mockito.model.User;

import java.util.Arrays;
import java.util.List;

public class UserDaoImpl<user> implements UserDao<user> {

    private final List<User> users = Arrays.asList(
            new User( "Иван", 21),
            new User( "Петр", 22),
            new User( "Стас", 23)
    );

    @Override
    public User getUserByName(String name) {
        for (User user: users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return users.stream().toList();
    }
}
