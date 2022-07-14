package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUser(String email);

    List<UserDto> geAllUsersDto();

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);
}
