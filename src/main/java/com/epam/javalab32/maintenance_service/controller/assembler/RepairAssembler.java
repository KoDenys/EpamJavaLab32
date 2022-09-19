package com.epam.javalab32.maintenance_service.controller.assembler;

import com.epam.javalab32.maintenance_service.controller.RepairController;
import com.epam.javalab32.maintenance_service.controller.model.RepairModel;
import com.epam.javalab32.maintenance_service.dto.RepairDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RepairAssembler extends RepresentationModelAssemblerSupport<RepairDto, RepairModel> {
    public static final String GET_REPAIR = "get_repair";
    public static final String GET_ALL_REPAIRS = "get_repairs";
    public static final String GET_ALL_REPAIRS_FOR_CAR= "get_repairs_for_car";
    public static final String CREATE_REPAIR = "create_repair";
    public static final String UPDATE_REPAIR = "update_repair";
    public static final String DELETE_REPAIR = "delete_repair";

    public RepairAssembler() {
        super(RepairController.class, RepairModel.class);
    }

    @Override
    public RepairModel toModel(RepairDto entity) {
        RepairModel repairModel = new RepairModel(entity);

        Link get = linkTo(methodOn(RepairController.class).getRepair(entity.getRepairId())).withRel(GET_REPAIR);
        Link create = linkTo(methodOn(RepairController.class).createRepair(entity)).withRel(CREATE_REPAIR);
        Link update = linkTo(methodOn(RepairController.class).updateRepair(entity)).withRel(UPDATE_REPAIR);
        Link delete = linkTo(methodOn(RepairController.class).deleteRepair(entity.getRepairId())).withRel(DELETE_REPAIR);

        repairModel.add(get, create, update, delete);
        return repairModel;
    }

    @Override
    public CollectionModel<RepairModel> toCollectionModel(Iterable<? extends RepairDto> entities)
    {
        CollectionModel<RepairModel> repairModels = super.toCollectionModel(entities);

        Link getAll = linkTo(methodOn(RepairController.class).getAllRepairs()).withRel(GET_ALL_REPAIRS);
        Link getAllForCar = linkTo(methodOn(RepairController.class).getRepairForCar(entities.iterator().next().getCarId())).withRel(GET_ALL_REPAIRS_FOR_CAR);

        repairModels.add(getAll, getAllForCar);
        return repairModels;
    }
}
