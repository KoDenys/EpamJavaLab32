package com.epam.javalab32.maintenance_service.api;

import com.epam.javalab32.maintenance_service.controller.model.CarModel;
import com.epam.javalab32.maintenance_service.dto.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Car management API")
@RequestMapping("/api-service/car")
public interface CarApi {
    @ApiImplicitParam(name = "regNumber", paramType = "path", required = true, value = "Car registration number")
    @ApiOperation("Get car registration number")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{regNumber}")
    CarModel getCar(@PathVariable String regNumber);

    @ApiOperation("Get all cars")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<CarModel> getAllCars();

    @ApiImplicitParam(name = "userId", paramType = "path", required = true, value = "Car owner(user) id")
    @ApiOperation("Get all cars for user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{userId}")
    CollectionModel<CarModel> getCarsForUser(@PathVariable Long userId);

    @ApiOperation("Create car")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CarModel createCar(@RequestBody @Validated CarDto carDto);

    @ApiImplicitParam(name = "regNumber", paramType = "path", required = true, value = "Car registration number")
    @ApiOperation("Update car")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{regNumber}")
    CarModel updateCar(@PathVariable String regNumber, @RequestBody @Validated CarDto carDto);

    @ApiImplicitParam(name = "regNumber", paramType = "path", required = true, value = "Car registration number")
    @ApiOperation("Delete car")
    @DeleteMapping("/{regNumber}")
    ResponseEntity<Void> deleteCar(@PathVariable String regNumber);
}
