package com.nasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.Department;
import com.nasim.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	public List<Department> findByDepartments(String name) {

		return departmentRepo.findByName(name);
	}

	public List<Department> findByDepartmentlist() {

		return departmentRepo.findAll();
	}

}
