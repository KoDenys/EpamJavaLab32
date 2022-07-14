package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.Repair;

import java.util.List;

public interface RepairRepository {
   Repair getRepairById(Long repairId);

   List<Repair> getAllRepairs();

   List<Repair> getRepairsForCar (Long carId);

   Repair createRepair(Repair repair);

   Repair updateRepair(Long repairId, Repair repair);

   void deleteRepair(Long repairId);
}
