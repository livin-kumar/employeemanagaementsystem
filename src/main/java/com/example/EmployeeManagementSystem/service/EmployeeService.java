package com.example.EmployeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.Entity.EmployeeEntity;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepository er;
	
	@Override
	public EmployeeEntity insert(EmployeeEntity e) {
		
		EmployeeEntity emp=new EmployeeEntity();
		emp=er.save(e);
		return emp;
	}

	 @Override
	public List<EmployeeEntity> get() {
		
		List<EmployeeEntity> list=new ArrayList<EmployeeEntity>();
		list=er.findAll();
				
		return list;
	}

	 @Override
	public void delete(Long id) {
		
		er.deleteById(id);
		
	}

	 @Override
	public EmployeeEntity update(EmployeeEntity e,Long id) {
		EmployeeEntity emp=new EmployeeEntity();
		try
		{
			if(id>0)
			{
				emp=er.findById(id).get();
				emp.setName(e.getName());
				emp.setEmailid(e.getEmailid());
				emp.setQualification(e.getQualification());
				emp.setDomain(e.getDomain());
			    emp.setExperience(e.getExperience());
			    emp.setJobtitle(e.getJobtitle());
			    emp.setPerfomance(e.getPerfomance());
			    emp.setSalary(e.getSalary());
			
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		er.save(emp);
		return emp;
	}

	 @Override
	public EmployeeEntity findbyname(String name) {
		 EmployeeEntity emp=new EmployeeEntity();
			emp=er.findByName(name).get();
			return emp;
	}

}
