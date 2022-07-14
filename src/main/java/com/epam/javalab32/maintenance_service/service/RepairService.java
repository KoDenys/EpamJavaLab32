package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.RepairDto;

import java.util.List;

public interface RepairService {
    RepairDto getRepairById(Long repairId);

    List<RepairDto> getAllRepairs();

    List<RepairDto> getRepairsForCar (Long carId);

    RepairDto createRepair(RepairDto repairDto);

    RepairDto updateRepair(Long repairId, RepairDto repairDto);

    void deleteRepair(Long repairId);
}
