package com.epam.javalab32.maintenance_service.service.impl;

import com.epam.javalab32.maintenance_service.dto.RepairDto;
import com.epam.javalab32.maintenance_service.exception.RepairNotFoundException;
import com.epam.javalab32.maintenance_service.mappers.RepairMapper;
import com.epam.javalab32.maintenance_service.model.Car;
import com.epam.javalab32.maintenance_service.model.Repair;
import com.epam.javalab32.maintenance_service.repository.CarRepository;
import com.epam.javalab32.maintenance_service.repository.RepairRepository;
import com.epam.javalab32.maintenance_service.service.RepairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {
    private final RepairRepository repairRepository;
    private final CarRepository carRepository;

    @Override
    public RepairDto getRepairById(Long repairId) {
        log.info("Get repair with id {}", repairId);
        if(repairRepository.findById(repairId).isPresent()) {
            Repair repair = repairRepository.findById(repairId).get();
            repair.getCar().getUser().setCars(null);
            return RepairMapper.INSTANCE.repairToRepairDto(repair);
        }
        else{
            throw new RepairNotFoundException(repairId);
        }
    }

    @Override
    public List<RepairDto> getRepairsForCar(Long carId) {
        log.info("Get repairs for car with id {}", carId);
        Pageable sortedBySum =
                PageRequest.of(0, 3, Sort.by("repairSum").descending());
        return repairRepository.findAllByCarId(carId, sortedBySum).stream()
                    .peek(r -> r.getCar().setRepairs(null))
                    .map(RepairMapper.INSTANCE::repairToRepairDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<RepairDto> getAllRepairs() {
        log.info("Get all repairs");
        return repairRepository.findAll().stream()
                .map(RepairMapper.INSTANCE::repairToRepairDto)
                .collect(Collectors.toList());
    }

    @Override
    public RepairDto createRepair(RepairDto repairDto) {
        log.info("Create repair with id {}", repairDto.getRepairId());
        Car car = carRepository.getById(repairDto.getCarId());
        repairDto.setCar(car);
        Repair repair = RepairMapper.INSTANCE.repairDtoToRepair(repairDto);
        repair = repairRepository.save(repair);
        return RepairMapper.INSTANCE.repairToRepairDto(repair);
    }

    @Override
    public RepairDto updateRepair(RepairDto repairDto) {
        log.info("Update repair with id {}", repairDto.getRepairId());
        Repair repair = RepairMapper.INSTANCE.repairDtoToRepair(repairDto);
        repair = repairRepository.save(repair);
        return RepairMapper.INSTANCE.repairToRepairDto(repair);
    }

    @Override
    public void deleteRepair(Long repairId) {
        log.info("Delete repair with id {}", repairId);
        repairRepository.deleteById(repairId);
    }
}
