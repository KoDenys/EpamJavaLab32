package com.epam.javalab32.maintenance_service.mappers;

import com.epam.javalab32.maintenance_service.dto.CarDto;
import com.epam.javalab32.maintenance_service.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto carToCarDto(Car car);
    Car carDtoToCar(CarDto carDto);
}
