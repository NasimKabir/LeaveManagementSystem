package com.nasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nasim.model.Department;
import com.nasim.model.Employee_information;
import com.nasim.repository.DepartmentRepository;
import com.nasim.repository.EmployeeRepository;

@Service
public class EmployeeInformationService {
	@Autowired
	private EmployeeRepository empRepository;	
	
	// create an user according to role base

	public void createUser(Employee_information user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		empRepository.save(user);
	}

	public List<Employee_information> allUser() {
		return empRepository.findAll();

	}

	public List<Employee_information> allUserbyDepartmentname(String name) {
		return empRepository.findByDepartmentsName(name);

	}
	

}	
	

