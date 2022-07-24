package com.epam.javalab32.maintenance_service.api;

import com.epam.javalab32.maintenance_service.controller.model.UserModel;
import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.dto.group.OnCreate;
import com.epam.javalab32.maintenance_service.dto.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User management API")
@RequestMapping("/api-service/user")
public interface UserApi {
    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);

    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<UserModel> getAllUsers();

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Update user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    UserModel updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    @ApiOperation("Delete user")
    @DeleteMapping("/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);
}
