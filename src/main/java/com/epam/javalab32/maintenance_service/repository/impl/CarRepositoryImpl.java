package com.epam.javalab32.maintenance_service.repository.impl;

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
    public Car getCarByNumber(String number) {
        return cars.stream()
                .filter(car -> car.getRegistrationNumber().equals(number))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Car with number " + number + " not found."));
    }

    @Override
    public Car updateCar(String registrationNumber, Car car) {
        if(cars.removeIf(vehicle -> vehicle.getRegistrationNumber().equals(registrationNumber))) {
            cars.add(car);
        } else {
            throw new RuntimeException("Car with number" + registrationNumber + " is not found");
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
        if(carsForUser.isEmpty()) throw new RuntimeException("Cars is not found for this user");
        return carsForUser;
    }

    @Override
    public void deleteCar(String registrationNumber) {
        if(!cars.removeIf(vehicle -> vehicle.getRegistrationNumber().equals(registrationNumber))) {
            throw new RuntimeException("Car with number" + registrationNumber + " is not found");
        }
    }
}
