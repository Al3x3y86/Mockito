package com.example.mockito.service;

import com.example.mockito.dao.UserDaoImpl;
import com.example.mockito.model.User;

public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public boolean checkUserExist(User user) {
        if (user != null) {
            return userDaoImpl.getUserByName(user.getName()) != null;
        }
        return false;
    }
}
