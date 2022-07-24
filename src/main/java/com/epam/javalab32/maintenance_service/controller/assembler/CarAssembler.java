package com.epam.javalab32.maintenance_service.controller.assembler;

import com.epam.javalab32.maintenance_service.controller.CarController;
import com.epam.javalab32.maintenance_service.controller.model.CarModel;
import com.epam.javalab32.maintenance_service.dto.CarDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarAssembler extends RepresentationModelAssemblerSupport<CarDto, CarModel> {
    public static final String GET_CAR = "get_car";
    public static final String GET_ALL_CARS = "get_cars";
    public static final String GET_ALL_CARS_FOR_USER = "get_cars_for_user";
    public static final String CREATE_CAR = "create_car";
    public static final String UPDATE_CAR = "update_car";
    public static final String DELETE_CAR = "delete_car";

    public CarAssembler() {
        super(CarController.class, CarModel.class);
    }

    @Override
    public CarModel toModel(CarDto entity) {
       CarModel carModel = new CarModel(entity);

       Link get = linkTo(methodOn(CarController.class).getCar(entity.getRegistrationNumber())).withRel(GET_CAR);
       Link create = linkTo(methodOn(CarController.class).createCar(entity)).withRel(CREATE_CAR);
       Link update = linkTo(methodOn(CarController.class).updateCar(entity.getRegistrationNumber(), entity)).withRel(UPDATE_CAR);
       Link delete = linkTo(methodOn(CarController.class).deleteCar(entity.getRegistrationNumber())).withRel(DELETE_CAR);

       carModel.add(get, create, update, delete);
       return carModel;
    }

    @Override
    public CollectionModel<CarModel> toCollectionModel(Iterable<? extends CarDto> entities)
    {
        CollectionModel<CarModel> carModels = super.toCollectionModel(entities);

        Link getAll = linkTo(methodOn(CarController.class).getAllCars()).withRel(GET_ALL_CARS);
        Link getAllForUser = linkTo(methodOn(CarController.class).getCarsForUser(((CarDto) entities.iterator()).getUserId())).withRel(GET_ALL_CARS_FOR_USER);

        carModels.add(getAll, getAllForUser);
        return carModels;
    }
}
