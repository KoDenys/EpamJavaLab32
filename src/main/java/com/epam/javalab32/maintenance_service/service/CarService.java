package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.model.Car;

import java.util.List;

public interface CarService {
    CarDto getCarByNumber(String number);

    List<CarDto> getAllCars();

    List<CarDto> getCarsForUser(Long userId);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(String registrationNumber, CarDto carDto);

    void deleteCar(String registrationNumber);
}
