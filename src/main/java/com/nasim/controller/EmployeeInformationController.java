package com.nasim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nasim.model.Employee_information;
import com.nasim.repository.DepartmentRepository;
import com.nasim.service.EmployeeInformationService;

@Controller
public class EmployeeInformationController {
	@Autowired
	private EmployeeInformationService empService;
	
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
//	
//	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/createuser")
	public String UseRegisterForm(Model model) {
		model.addAttribute("user", new Employee_information());
	
		model.addAttribute("department",departmentRepo.findAll() );
		return "createUser";
	}
	
	@PostMapping("/success")
	public String registeringUser(Employee_information user, Model model) {
		empService.createUser(user);
		model.addAttribute("user", new Employee_information());
		model.addAttribute("department",departmentRepo.findAll() );
		return "successful";

	}
	

	@GetMapping("/viewUser")
	public ModelAndView viewLeave(Model model) {
		ModelAndView mav = new ModelAndView("viewUser");
		List<Employee_information> users=empService.allUser();
		boolean username=false;
		model.addAttribute("username", users);
		model.addAttribute("user",users);
		return mav;
	}

	@GetMapping(value = "/viewUserList")
	public String viewLeavebydepartment(Model model,@RequestParam String name) {
			List<Employee_information> users=empService.allUserbyDepartmentname(name);
			model.addAttribute("user",users);
			return "viewUserList";	
		
	}
	
	@GetMapping("/access-denied")
	public ModelAndView AccessDenied() {
		ModelAndView mav = new ModelAndView("access-denied");
		return mav;
	}

	
}
