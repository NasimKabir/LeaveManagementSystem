package com.nasim.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasim.model.Department;
import com.nasim.model.Employee_information;

public interface EmployeeRepository extends JpaRepository<Employee_information, Integer> {
	public List<Employee_information> findByDepartmentsName(String name);

	//Optional<Employee_information> findByUsername(String username);
	Employee_information findByUsername(String username);
	
}
