package com.epam.javalab32.maintenance_service.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class User {
    private Long userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean active;

    private UserType userType;
    private List<Car> cars;
}
