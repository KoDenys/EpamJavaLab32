package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.api.CarApi;
import com.epam.javalab32.maintenance_service.controller.assembler.CarAssembler;
import com.epam.javalab32.maintenance_service.controller.model.CarModel;
import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {
    private final CarService carService;
    private final CarAssembler carAssembler;

   @Override
    public CarModel getCar(String regNumber) {
        CarDto carDto = carService.getCarByNumber(regNumber);
        return carAssembler.toModel(carDto);
    }

    @Override
    public CollectionModel<CarModel> getAllCars() {
        List<CarDto> carsDto = carService.getAllCars();
        return carAssembler.toCollectionModel(carsDto);
    }

    @Override
    public CollectionModel<CarModel> getAllCarsWithRepairs() {
        List<CarDto> carsDto = carService.getAllCarsWithRepairs();
        return carAssembler.toCollectionModel(carsDto);
    }

    @Override
    public CollectionModel<CarModel> getCarsForUser(Long userId) {
        List<CarDto> carsDto = carService.getCarsForUser(userId);
        return carAssembler.toCollectionModel(carsDto);
    }

    @Override
    public CarModel createCar(CarDto carDto) {
        CarDto createdCarDto = carService.createCar(carDto);
        return carAssembler.toModel(createdCarDto);
}

    @Override
    public CarModel updateCar(CarDto carDto) {
        CarDto updatedCarDto = carService.updateCar(carDto);
        return carAssembler.toModel(updatedCarDto);
    }

    @Override
    public ResponseEntity<Void> deleteCar(String regNumber) {
        carService.deleteCar(regNumber);
        return ResponseEntity.noContent().build();
    }
}
