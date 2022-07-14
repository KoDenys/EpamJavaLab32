package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.User;

import java.util.List;

public interface UserRepository {
    User getUserByEmail(String email);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(String userEmail, User user);

    void deleteUser(String email);
}
