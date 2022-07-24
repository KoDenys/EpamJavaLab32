package com.epam.javalab32.maintenance_service.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
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
    private Long userId;
}
