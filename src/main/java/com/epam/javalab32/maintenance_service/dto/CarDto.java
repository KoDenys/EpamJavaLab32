package com.epam.javalab32.maintenance_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private Long carId;
    private String registrationNumber;
    private String carName;
    private String model;
    private String color;
    private int yearManufacture;
    private int mileage;
    private boolean blocked;
    private Long userId;
}
