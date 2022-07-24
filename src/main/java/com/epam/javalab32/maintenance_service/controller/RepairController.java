package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.api.RepairApi;
import com.epam.javalab32.maintenance_service.controller.assembler.RepairAssembler;
import com.epam.javalab32.maintenance_service.controller.model.RepairModel;
import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepairController implements RepairApi {
    private final RepairService repairService;
    private final RepairAssembler repairAssembler;

    @Override
    public RepairModel getRepair(Long repairId) {
        RepairDto repairDto = repairService.getRepairById(repairId);
        return repairAssembler.toModel(repairDto);
    }

    @Override
    public CollectionModel<RepairModel> getRepairForCar(Long carId) {
        List<RepairDto> repairsDto = repairService.getRepairsForCar(carId);
        return repairAssembler.toCollectionModel(repairsDto);
    }

    @Override
    public CollectionModel<RepairModel> getAllRepairs() {
        List<RepairDto> repairsDto = repairService.getAllRepairs();
        return repairAssembler.toCollectionModel(repairsDto);
    }

    @Override
    public RepairModel createRepair(RepairDto repairDto) {
        RepairDto createdRepairDto = repairService.createRepair(repairDto);
        return repairAssembler.toModel(createdRepairDto);
    }

    @Override
    public RepairModel updateRepair(Long repairId, RepairDto repairDto) {
        RepairDto updatedRepairDto = repairService.updateRepair(repairId, repairDto);
        return repairAssembler.toModel(updatedRepairDto);
    }

    @Override
    public ResponseEntity<Void> deleteRepair(Long repairId) {
        repairService.deleteRepair(repairId);
        return ResponseEntity.noContent().build();
    }
}
