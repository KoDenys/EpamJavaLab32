package com.epam.javalab32.maintenance_service.api;

import com.epam.javalab32.maintenance_service.controller.model.RepairModel;
import com.epam.javalab32.maintenance_service.dto.RepairDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Repair management API")
@RequestMapping("/api-service/repair")
public interface RepairApi {
    @ApiImplicitParam(name = "repairId", paramType = "path", required = true, value = "Repair id")
    @ApiOperation("Get repair by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{repairId}")
    RepairModel getRepair(@PathVariable Long repairId);

    @ApiImplicitParam(name = "carId", paramType = "path", required = true, value = "Repaired car id")
    @ApiOperation("Get repairs for car")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/car/{carId}")
    CollectionModel<RepairModel> getRepairForCar(@PathVariable Long carId);

    @ApiOperation("Get all repairs")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    CollectionModel<RepairModel> getAllRepairs();

    @ApiOperation("Create repair")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RepairModel createRepair(@RequestBody @Validated RepairDto repairDto);

    @ApiOperation("Update repair")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    RepairModel updateRepair(@RequestBody @Validated RepairDto repairDto);

    @ApiImplicitParam(name = "repairId", paramType = "path", required = true, value = "Repair id")
    @ApiOperation("Delete repair")
    @DeleteMapping("/{repairId}")
    ResponseEntity<Void> deleteRepair(@PathVariable Long repairId);
}
