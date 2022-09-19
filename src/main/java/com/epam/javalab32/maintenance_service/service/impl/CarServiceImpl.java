package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.exception.UserNotFoundException;
import com.epam.javalab32.maintenance_service.mappers.CarMapper;
import com.epam.javalab32.maintenance_service.model.Car;
import com.epam.javalab32.maintenance_service.model.User;
import com.epam.javalab32.maintenance_service.repository.CarRepository;
import com.epam.javalab32.maintenance_service.repository.UserRepository;
import com.epam.javalab32.maintenance_service.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public CarDto getCarByNumber(String number) {
        log.info("Get car with number {}", number);
            Car car = carRepository.getCarByRegistrationNumber(number);
            car.getUser().setCars(null);
            return CarMapper.INSTANCE.carToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        log.info("Get all cars");
        return carRepository.findAll(Sort.by("carName")).stream()
                .peek(c -> c.getUser().setCars(null))
                .map(CarMapper.INSTANCE::carToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getAllCarsWithRepairs() {
        log.info("Get all cars");
        return carRepository.findAllCarsWithRepair().stream()
                .map(CarMapper.INSTANCE::carToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsForUser(Long userId) {
        log.info("Get cars for user with id {}", userId);
        Pageable sortedByName =
                PageRequest.of(0, 3);
        return carRepository.findAllCarsForUser(userId,sortedByName).stream()
                .peek(c -> c.getUser().setCars(null))
                .map(CarMapper.INSTANCE::carToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackOn = SQLException.class)
    public CarDto createCar(CarDto carDto) {
        log.info("Create car with registration number {}", carDto.getRegistrationNumber());
        if(userRepository.findById(carDto.getUserId()).isPresent()) {
            User user = userRepository.findById(carDto.getUserId()).get();
            user.setCars(null);
            System.out.println(user);
            Car car = CarMapper.INSTANCE.carDtoToCar(carDto);
            car.setUser(user);
            car = carRepository.save(car);
            return CarMapper.INSTANCE.carToCarDto(car);
        }
        else{
            throw new UserNotFoundException(carDto.getUserId());
        }
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        log.info("Update car with registration number {}", carDto.getRegistrationNumber());
        Car car = CarMapper.INSTANCE.carDtoToCar(carDto);
        car = carRepository.save(car);
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    @Override
    public void deleteCar(String registrationNumber) {
        log.info("Delete car with registration number {}", registrationNumber);
        carRepository.deleteCarByRegistrationNumber(registrationNumber);
    }
}
