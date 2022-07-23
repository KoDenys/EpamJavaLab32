package com.epam.javalab32.maintenance_service.repository.impl;

import com.epam.javalab32.maintenance_service.exception.UserNotFoundException;
import com.epam.javalab32.maintenance_service.model.User;
import com.epam.javalab32.maintenance_service.model.UserType;
import com.epam.javalab32.maintenance_service.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        user.setUserType(UserType.USER);
        users.add(user);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public List <User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public User updateUser(String userEmail, User user) {
        if(users.removeIf(usr -> usr.getEmail().equals(userEmail))) {
            users.add(user);
        } else {
            throw new UserNotFoundException(userEmail);
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        if(!users.removeIf(user -> user.getEmail().equals(email))) {
            throw new UserNotFoundException(email);
        }
    }
}
