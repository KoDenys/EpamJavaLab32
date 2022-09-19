package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    CarDto getCarByNumber(String number);

    List<CarDto> getAllCars();

    List<CarDto> getAllCarsWithRepairs();

    List<CarDto> getCarsForUser(Long userId);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(CarDto carDto);

    void deleteCar(String registrationNumber);
}
