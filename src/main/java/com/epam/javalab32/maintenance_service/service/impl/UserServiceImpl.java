package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.mappers.UserMapper;
import com.epam.javalab32.maintenance_service.model.User;
import com.epam.javalab32.maintenance_service.repository.UserRepository;
import com.epam.javalab32.maintenance_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("Get user {}", email);
        User user = userRepository.getUserByEmail(email);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public List<UserDto> geAllUsersDto() {
        log.info("Get all usersDto");
        return userRepository.getAllUsers().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("Create user with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.createUser(user);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("Update user with email {}", email);
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("Delete user with email {}", email);
        userRepository.deleteUser(email);
    }
}
