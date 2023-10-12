package com.example.EmployeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.Entity.EmployeeEntity;
import com.example.EmployeeManagementSystem.service.EmployeeService;


@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
  
	@Autowired
	private EmployeeService es;
	
	@GetMapping
	public String welcome()
	{
		return "Welcome to Employee Management System";
	}
    
	@PostMapping("/insert")
	public String insert(@RequestBody EmployeeEntity e)
	{
		EmployeeEntity emp=new EmployeeEntity();
		emp=es.insert(e);
		return "Data Inserted Sucessfully";
	}

	@GetMapping("/getallemployeedetails")
	public List<EmployeeEntity> get()
	{
		List<EmployeeEntity> list=new ArrayList<EmployeeEntity>();
		list=es.get();
		return list;
		
	}
	
	@GetMapping("/findbyname/{name}")
	public EmployeeEntity findbyname(@PathVariable String name)
	{
		EmployeeEntity emp=new EmployeeEntity();
		emp=es.findbyname(name);
		return emp;
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody EmployeeEntity e,@PathVariable Long id)
	{
		EmployeeEntity emp=new EmployeeEntity();
		emp=es.update(e,id);
		return "Data Updated Sucessfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		es.delete(id);
		return "Data Deleted sucessfully";	
	}
	
}
