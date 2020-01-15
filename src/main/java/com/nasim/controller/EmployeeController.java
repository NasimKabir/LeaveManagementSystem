package com.nasim.controller;

import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nasim.model.Employee_information;
import com.nasim.repository.DepartmentRepository;
import com.nasim.repository.RoleRepository;
import com.nasim.service.EmployeeInformationService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeInformationService empService;


	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private RoleRepository roleRepository;

	private Path path;

	@GetMapping("/createuser")
	public String UseRegisterForm(Model model) {
		model.addAttribute("user", new Employee_information());
		return "createUser/createUser";
	}

	@PostMapping("/success")
	public String registeringUser(Employee_information emp, Model model, HttpServletRequest request) {

		// emp.setProfilePic(ImageFileUpload.saveImageName(emp.getUserImage(),
		// emp.getUsername(), request));
		empService.createUser(emp);
		return "successful";

	}

	@GetMapping(value = "/viewUser")
	public String viewLeavebydepartment(Model model, @RequestParam(defaultValue = "0", name = "page") int page,@RequestParam(defaultValue = "") String name) {
		Page<Employee_information> users = empService.allUserbyDepartmentname(new PageRequest(page, 8), name);
		model.addAttribute("user", users);
		return "user/viewUser";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id,Model model) {
		empService.getEmployeeOnId(id);
		empService.deleteUser(id);
		return "redirect:user/viewUser";

	}

	@GetMapping("/u/{id}")
	public String updateUserInfo(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", empService.getEmployeeOnId(id));
		return "createUser/updateUser";
	}

	@PostMapping("/updatesuccess")
	public String UpdateUser(Employee_information emp) {
		empService.createUser(emp);
		return "redirect:user/viewUser";

	}

	@GetMapping("/access-denied")
	public ModelAndView AccessDenied() {
		ModelAndView mav = new ModelAndView("access-denied");
		return mav;
	}

}
