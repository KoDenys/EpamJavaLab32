package com.epam.javalab32.maintenance_service.dto;

import com.epam.javalab32.maintenance_service.model.UserType;
import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean active;

    private UserType userType;
}
