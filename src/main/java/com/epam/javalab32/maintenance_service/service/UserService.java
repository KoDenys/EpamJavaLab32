package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto getUser(String email);

    List<UserDto> geAllUsersDto();

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(String email);
}
