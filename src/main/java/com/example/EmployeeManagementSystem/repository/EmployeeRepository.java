package com.example.EmployeeManagementSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.Entity.EmployeeEntity;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    Optional<EmployeeEntity> findByName(String name); 	
   
}