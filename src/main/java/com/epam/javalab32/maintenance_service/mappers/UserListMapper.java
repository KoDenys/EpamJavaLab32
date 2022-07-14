package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserListMapper {
    @Mapping(target = "repeatPassword", ignore = true)
    @Mapping(target = "password", ignore = true)
    List<UserDto> listUserToUserDto(List<User> users);
    List<User> listUserDtoToUser(List<UserDto> usersDto);
}
