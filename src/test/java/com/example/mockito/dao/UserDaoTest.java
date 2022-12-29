package com.example.mockito.dao;

import com.example.mockito.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserDaoTest {

    private final User Ivan = new User("Иван", 21);
    private final User Masha = new User("Маша", 31);

    @Test
    @DisplayName("Проверка юзера с существующем именем из списка")
    void getUserByName() {
        assertNotNull(new UserDaoImpl<>().getUserByName(Ivan.getName()));
        assertEquals("Иван", new UserDaoImpl().getUserByName(Ivan.getName()).getName());
    }

    @Test
    @DisplayName("Проверка юзера c не существующем именем в списке")
    void getNonUserByName() {
        assertNull(new UserDaoImpl().getUserByName(Masha.getName()));
    }
}