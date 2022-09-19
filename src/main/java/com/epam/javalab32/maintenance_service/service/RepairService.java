package com.epam.javalab32.maintenance_service.service;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepairService {
    RepairDto getRepairById(Long repairId);

    List<RepairDto> getAllRepairs();

    List<RepairDto> getRepairsForCar (Long carId);

    RepairDto createRepair(RepairDto repairDto);

    RepairDto updateRepair(RepairDto repairDto);

    void deleteRepair(Long repairId);
}
