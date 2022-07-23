package com.epam.javalab32.maintenance_service.repository.impl;

import com.epam.javalab32.maintenance_service.exception.RepairNotFoundException;
import com.epam.javalab32.maintenance_service.model.Repair;
import com.epam.javalab32.maintenance_service.repository.RepairRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepairRepositoryIml implements RepairRepository {
    private final List<Repair> repairs = new ArrayList<>();

    @Override
    public Repair createRepair(Repair repair) {
        repairs.add(repair);
        return repair;
    }

    @Override
    public Repair getRepairById(Long repairId) {
        return repairs.stream()
                .filter(repair -> repair.getRepairId().equals(repairId))
                .findFirst()
                .orElseThrow(()-> new RepairNotFoundException(repairId));
    }

    @Override
    public List<Repair> getAllRepairs() {
        return new ArrayList<>(repairs);
    }

    @Override
    public List<Repair> getRepairsForCar(Long carId) {
        List <Repair> repairsForCar = repairs.stream()
                .filter(repair -> repair.getRepairedCarId().equals(carId))
                .collect(Collectors.toList());
        if(repairsForCar.isEmpty()) throw new RepairNotFoundException();
        return repairsForCar;
    }

    @Override
    public Repair updateRepair(Long repairId, Repair repair) {
        if(repairs.removeIf(rep -> rep.getRepairId().equals(repairId))) {
            repairs.add(repair);
        } else {
            throw new RepairNotFoundException(repairId);
        }
        return repair;
    }

    @Override
    public void deleteRepair(Long repairId) {
        if(!repairs.removeIf(repair -> repair.getRepairId().equals(repairId))) {
            throw new RepairNotFoundException(repairId);
        }
    }
}
