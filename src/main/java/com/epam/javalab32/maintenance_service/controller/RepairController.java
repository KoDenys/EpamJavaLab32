package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
@RequiredArgsConstructor
public class RepairController {
    private final RepairService repairService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{repairId}")
    public RepairDto getRepair(@PathVariable Long repairId) {
        return repairService.getRepairById(repairId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/car/{carId}")
    public List<RepairDto> getRepairForCar(@PathVariable Long carId) {
        return repairService.getRepairsForCar(carId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<RepairDto> getAllRepairs() {
        return repairService.getAllRepairs();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RepairDto createRepair(@RequestBody RepairDto repairDto) {
        return repairService.createRepair(repairDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{repairId}")
    public RepairDto updateRepair(@PathVariable Long repairId, @RequestBody RepairDto repairDto) {
        return repairService.updateRepair(repairId, repairDto);
    }

    @DeleteMapping("/{repairId}")
    public ResponseEntity<Void> deleteRepair(@PathVariable Long repairId) {
        repairService.deleteRepair(repairId);
        return ResponseEntity.noContent().build();
    }
}
