package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{regNumber}")
    public CarDto getCar(@PathVariable String regNumber) {
        return carService.getCarByNumber(regNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}")
    public List<CarDto> getCarsForUser(@PathVariable Long userId) {
        return carService.getCarsForUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CarDto createCar(@RequestBody @Validated CarDto carDto) {
        return carService.createCar(carDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{regNumber}")
    public CarDto updateCar(@PathVariable String regNumber, @RequestBody @Validated CarDto carDto) {
        return carService.updateCar(regNumber, carDto);
    }

    @DeleteMapping("/{regNumber}")
    public ResponseEntity<Void> deleteCar(@PathVariable String regNumber) {
        carService.deleteCar(regNumber);
        return ResponseEntity.noContent().build();
    }
}
