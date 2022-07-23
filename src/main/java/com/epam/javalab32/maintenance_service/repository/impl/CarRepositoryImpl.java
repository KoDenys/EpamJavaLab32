package com.epam.javalab32.maintenance_service.repository.impl;

import com.epam.javalab32.maintenance_service.exception.CarNotFoundException;
import com.epam.javalab32.maintenance_service.model.Car;
import com.epam.javalab32.maintenance_service.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRepositoryImpl implements CarRepository {
    private final List <Car> cars = new ArrayList<>();

    @Override
    public Car createCar(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car getCarByNumber(String regNumber) {
        return cars.stream()
                .filter(car -> car.getRegistrationNumber().equals(regNumber))
                .findFirst()
                .orElseThrow(()-> new CarNotFoundException(regNumber));
    }

    @Override
    public Car updateCar(String regNumber, Car car) {
        if(cars.removeIf(vehicle -> vehicle.getRegistrationNumber().equals(regNumber))) {
            cars.add(car);
        } else {
            throw new CarNotFoundException(regNumber);
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public List<Car> getCarsForUser(Long userId) {
        List <Car> carsForUser = cars.stream()
                .filter(car -> car.getUserId().equals(userId))
                .collect(Collectors.toList());
        if(carsForUser.isEmpty()) throw new CarNotFoundException();
        return carsForUser;
    }

    @Override
    public void deleteCar(String regNumber) {
        if(!cars.removeIf(vehicle -> vehicle.getRegistrationNumber().equals(regNumber))) {
            throw new CarNotFoundException(regNumber);
        }
    }
}
