package com.example.mockito.service;

import com.example.mockito.dao.UserDaoImpl;
import com.example.mockito.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final UserDaoImpl userDao = Mockito.mock(UserDaoImpl.class);
    private final UserServiceImpl userService;

    public UserServiceTest() {
        userService = new UserServiceImpl(userDao);
    }

    @Test
    @DisplayName("Тест на возврат true")
    void checkUserExist() {
        User Ivan = new User("Иван", 21);
        when(userDao.getUserByName("Иван")).thenReturn(Ivan);
        boolean checkUser = userService.checkUserExist(Ivan);
        assertTrue(checkUser);
    }

    @Test
    @DisplayName("Тест на возврат false")
    void checkNonUserExist() {
        User Masha = null;
        when(userDao.getUserByName("Маша")).thenReturn(null);
        boolean checkUser = userService.checkUserExist(null);
        assertFalse(checkUser);
    }
}