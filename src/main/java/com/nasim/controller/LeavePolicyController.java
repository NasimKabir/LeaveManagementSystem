package com.nasim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nasim.model.LeavePolicy;
import com.nasim.service.LeavePolicyService;

@Controller
public class LeavePolicyController {
	@Autowired
	private LeavePolicyService leaveService;

	@GetMapping("/leavepolicy")
	public String LeavePolicyCreationForm(Model model) {
		model.addAttribute("leavePolicy", new LeavePolicy());
		return "leavePolicyCreation";
	}

	@PostMapping("/successfull")
	public String LeavePolicyCreation(LeavePolicy policy) {
		leaveService.createLeavePolicy(policy);
		return "successfull";

	}
}
