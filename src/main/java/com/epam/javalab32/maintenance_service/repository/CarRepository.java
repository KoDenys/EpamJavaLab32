package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.Car;

import java.util.List;

public interface CarRepository {
    Car getCarByNumber(String number);

    List<Car> getAllCars();

    List<Car> getCarsForUser(Long userId);

    Car createCar(Car car);

    Car updateCar(String registrationNumber, Car car);

    void deleteCar(String registrationNumber);
}
