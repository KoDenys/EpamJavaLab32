package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.model.Car;
import com.epam.javalab32.maintenance_service.repository.CarRepository;
import com.epam.javalab32.maintenance_service.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public CarDto getCarByNumber(String number) {
        log.info("Get car with number {}", number);
        Car car = carRepository.getCarByNumber(number);
        return mapCarToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        log.info("Get all cars");
        return carRepository.getAllCars().stream()
                .map(this::mapCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsForUser(Long userId) {
        log.info("Get cars for user with id {}", userId);
        return carRepository.getCarsForUser(userId).stream()
                .map(this::mapCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        log.info("Create car with registration number {}", carDto.getRegistrationNumber());
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(String registrationNumber, CarDto carDto) {
        log.info("Update car with registration number {}", registrationNumber);
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(registrationNumber, car);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(String registrationNumber) {
        log.info("Delete car with registration number {}", registrationNumber);
        carRepository.deleteCar(registrationNumber);
    }

    private CarDto mapCarToCarDto(Car car) {
        return CarDto.builder()
                .carId(car.getCarId())
                .registrationNumber(car.getRegistrationNumber())
                .carName(car.getCarName())
                .model(car.getModel())
                .color(car.getColor())
                .yearManufacture(car.getYearManufacture())
                .mileage(car.getMileage())
                .blocked(car.isBlocked())
                .userId(car.getUserId())
                .build();

    }

    private Car mapCarDtoToCar(CarDto carDto) {
        return Car.builder()
                .carId(carDto.getCarId())
                .registrationNumber(carDto.getRegistrationNumber())
                .carName(carDto.getCarName())
                .model(carDto.getModel())
                .color(carDto.getColor())
                .yearManufacture(carDto.getYearManufacture())
                .mileage(carDto.getMileage())
                .blocked(carDto.isBlocked())
                .userId(carDto.getUserId())
                .build();

    }
}
