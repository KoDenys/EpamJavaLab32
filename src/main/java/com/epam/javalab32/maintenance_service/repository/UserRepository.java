package com.epam.javalab32.maintenance_service.repository;

import com.epam.javalab32.maintenance_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAll();

    void deleteByEmail(String email);
}
