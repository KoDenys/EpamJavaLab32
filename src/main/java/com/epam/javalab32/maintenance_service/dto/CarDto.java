package com.epam.javalab32.maintenance_service.dto;

import com.epam.javalab32.maintenance_service.model.Repair;
import com.epam.javalab32.maintenance_service.model.User;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Long carId;
    @Size(min = 2, max = 8, message = "Registration number should contain from 2 to 8 symbols")
    private String registrationNumber;
    @NotBlank(message = "Car name shouldn't be empty")
    private String carName;
    @NotBlank(message = "Car model shouldn't be empty")
    private String model;
    @NotBlank(message = "Car color shouldn't be empty")
    private String color;
    @Min(1900)
    @Max(2022)
    private int yearManufacture;
    @PositiveOrZero(message = "Car mileage shouldn't be negative")
    private int mileage;
    @NotNull(message = "Set active status for this car")
    private boolean blocked;
    private List<Repair> repairs;
    private Long userId;
    private User user;
}
