package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.model.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarListMapper {
    List<CarDto> listCarToCarDto(List<Car> cars);
    List<Car> listCarDtoToCar(List<CarDto> carsDto);
}
