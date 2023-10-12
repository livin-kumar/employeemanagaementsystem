package com.example.EmployeeManagementSystem.service;

import java.util.List;

import com.example.EmployeeManagementSystem.Entity.EmployeeEntity;

public interface EmployeeServiceInterface {

       public EmployeeEntity insert(EmployeeEntity e);
	   public List<EmployeeEntity> get();
	   public void delete(Long id);
	   public EmployeeEntity update(EmployeeEntity e, Long id);
       public EmployeeEntity findbyname(String name);
	 
}




