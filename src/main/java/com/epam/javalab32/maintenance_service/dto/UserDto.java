package com.epam.javalab32.maintenance_service.dto;

import com.epam.javalab32.maintenance_service.custom_validation.PhoneNumberConstraint;
import com.epam.javalab32.maintenance_service.dto.group.OnCreate;
import com.epam.javalab32.maintenance_service.dto.group.OnUpdate;
import com.epam.javalab32.maintenance_service.model.Car;
import com.epam.javalab32.maintenance_service.model.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class UserDto {
    private Long userId;
    @Email(groups = {OnCreate.class, OnUpdate.class})
    private String email;
    @NotBlank(message = "password shouldn't be empty", groups = OnCreate.class)
    @Null(message = "Password should be missed in request")
    private String password;
    @NotBlank(message = "Repeat password shouldn't be empty", groups = OnCreate.class)
    @Null(message = "Repeat password should be missed in request")
    private String repeatPassword;
    @NotBlank(message = "First name shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String firstName;
    @NotBlank(message = "First name shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String lastName;
    @PhoneNumberConstraint(groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;
    @AssertTrue(groups = OnCreate.class)
    private boolean active;

    @NotNull
    private UserType userType;
    private List<Car> cars;
}
