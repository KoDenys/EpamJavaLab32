package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car getCarByRegistrationNumber(String registrationNumber);

    List<Car> findAll(Sort sort);

    List<Car> findAllCarsForUser(Long userId, Pageable pageable);

    @Query(nativeQuery = true)
    List<Car> findAllCarsWithRepair();

    void deleteCarByRegistrationNumber(String registrationNumber);
}
