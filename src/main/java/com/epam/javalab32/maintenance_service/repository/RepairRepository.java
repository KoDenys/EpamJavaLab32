package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.Repair;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

   @Query("select r from Repair r where r.car.carId =?1")
   List<Repair> findAllByCarId (Long carId, Pageable pageable);
}
