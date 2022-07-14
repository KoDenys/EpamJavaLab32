package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.UserDto;
import com.epam.javalab32.maintenance_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "repeatPassword", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
