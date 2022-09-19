package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.exception.UserNotFoundException;
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
    public UserDto createUser(UserDto userDto){
        log.info("Create user with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto getUser(String email) {
        log.info("Get user {}", email);
        User user = userRepository.findByEmail(email);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public List<UserDto> geAllUsersDto() {
        log.info("Get all usersDto");
        if(!userRepository.findAll().isEmpty()) {
            return userRepository.findAll().stream()
                    .map(UserMapper.INSTANCE::userToUserDto)
                    .collect(Collectors.toList());
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        log.info("Update user with email {}", userDto.getEmail());
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("Delete user with email {}", email);
        userRepository.deleteByEmail(email);
    }
}
