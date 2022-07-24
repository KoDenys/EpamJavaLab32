package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.api.UserApi;
import com.epam.javalab32.maintenance_service.controller.assembler.UserAssembler;
import com.epam.javalab32.maintenance_service.controller.model.UserModel;
import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.dto.group.OnCreate;
import com.epam.javalab32.maintenance_service.dto.group.OnUpdate;
import com.epam.javalab32.maintenance_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        UserDto userDto = userService.getUser(email);
        return userAssembler.toModel(userDto);
    }

    @Override
    public CollectionModel<UserModel> getAllUsers() {
        List<UserDto> usersDto = userService.geAllUsersDto();
        return userAssembler.toCollectionModel(usersDto);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        UserDto createdUserDto = userService.createUser(userDto);
        return userAssembler.toModel(createdUserDto);
    }

    @Override
    public UserModel updateUser(String email, UserDto userDto) {
        UserDto updatedUserDto = userService.updateUser(email, userDto);
        return userAssembler.toModel(updatedUserDto);
    }

   @Override
    public ResponseEntity<Void> deleteUser(String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
