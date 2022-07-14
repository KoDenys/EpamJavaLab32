package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.mappers.RepairMapper;
import com.epam.javalab32.maintenance_service.model.Repair;
import com.epam.javalab32.maintenance_service.repository.RepairRepository;
import com.epam.javalab32.maintenance_service.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;

    @Override
    public RepairDto getRepairById(Long repairId) {
        log.info("Get repair with id {}", repairId);
        Repair repair = repairRepository.getRepairById(repairId);
        return RepairMapper.INSTANCE.repairToRepairDto(repair);
    }

    @Override
    public List<RepairDto> getRepairsForCar(Long carId) {
        log.info("Get repairs for car with id {}", carId);
        return repairRepository.getRepairsForCar(carId).stream()
                .map(RepairMapper.INSTANCE::repairToRepairDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairDto> getAllRepairs() {
        log.info("Get all repairs");
        return repairRepository.getAllRepairs().stream()
                .map(RepairMapper.INSTANCE::repairToRepairDto)
                .collect(Collectors.toList());
    }

    @Override
    public RepairDto createRepair(RepairDto repairDto) {
        log.info("Create repair with id {}", repairDto.getRepairId());
        Repair repair = RepairMapper.INSTANCE.repairDtoToRepair(repairDto);
        repair = repairRepository.createRepair(repair);
        return RepairMapper.INSTANCE.repairToRepairDto(repair);
    }

    @Override
    public RepairDto updateRepair(Long repairId, RepairDto repairDto) {
        log.info("Update repair with id {}", repairId);
        Repair repair = RepairMapper.INSTANCE.repairDtoToRepair(repairDto);
        repair = repairRepository.updateRepair(repairId, repair);
        return RepairMapper.INSTANCE.repairToRepairDto(repair);
    }

    @Override
    public void deleteRepair(Long repairId) {
        log.info("Delete repair with id {}", repairId);
        repairRepository.deleteRepair(repairId);
    }
}
