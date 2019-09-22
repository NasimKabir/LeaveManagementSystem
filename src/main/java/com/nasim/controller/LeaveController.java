package com.nasim.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nasim.model.LeaveRequest;
import com.nasim.repository.EmployeeRepository;
import com.nasim.service.LeaveService;

@Controller
public class LeaveController {
	@Autowired
	private LeaveService leaveRequstService;
	
	@Autowired
	private EmployeeRepository userRepository;
	

	
	@GetMapping(value = "/apply_leave")
	public ModelAndView applyLeave(Model model) {
		ModelAndView mav = new ModelAndView("applyleaveapplication");
		model.addAttribute("leaveRequest",new LeaveRequest());
		return mav;
	}

	@PostMapping(value = "/leave_success")
	public ModelAndView submitApplyLeave(@ModelAttribute("leaveRequest")LeaveRequest leaveRequest,Model model) {
		
		ModelAndView mav = new ModelAndView("successful");
		model.addAttribute("user",userRepository.findAll());
		leaveRequest.setFromDate(new Date());
		leaveRequest.setToDate(new Date());
		leaveRequest.setAcceptRejectFlag("Pending");
		leaveRequstService.save(leaveRequest);
		
		return mav;
	}
	
	
	
	
	@GetMapping(value = "/view_leave")
	public ModelAndView viewLeave(Model model) {
		ModelAndView mav = new ModelAndView("viewLeaveApplication");
		List<LeaveRequest> request=leaveRequstService.allleaveRequest();
		model.addAttribute("leaverequest",request);
		return mav;
	}
	 
	
	
	
	@GetMapping( "/edit/{id}")
    public String viewLeaveApplication( @PathVariable("id") int id,Model model) {
	LeaveRequest leaveRequest = leaveRequstService.getLeaveRequestOnId(id);
	 model.addAttribute("leaveRequest",leaveRequest);
	return "recommendedapplication";
    }
	
	 @GetMapping("/edit/{id}/{id}")
	    public String updateLeaveApplication( @PathVariable("id") int id, Model model) {
		 LeaveRequest leaveRequest = leaveRequstService.getLeaveRequestOnId(id);
	        model.addAttribute("leaveRequest",leaveRequest);
	        return "comments";
	    }

	 @PostMapping("/commentssuccess")
	 public ModelAndView CommentsLeaveApplication(@ModelAttribute("leaveRequest")LeaveRequest leaveRequest) {	
			ModelAndView mav = new ModelAndView("successful");
			leaveRequstService.save(leaveRequest);;
			
			return mav;
		}
	 
	 @GetMapping(value = "/view_granteleave")
		public ModelAndView viewCommentsLeaveApplication(Model model) {
			ModelAndView mav = new ModelAndView("viewCommentsLeaveApplicationList");
			List<LeaveRequest> LeaveRequest=leaveRequstService.allleaveRequest();
			model.addAttribute("LeaveRequest",LeaveRequest);
			return mav;
		}
	 
	 
	 @GetMapping( "/approve/{id}")
	    public String acceptOrRejectLeaves( @PathVariable("id") int id,Model model) {
		LeaveRequest leaveRequest = leaveRequstService.getLeaveRequestOnId(id);
		 model.addAttribute("leaveRequest",leaveRequest);
		return "viewCommentsLeaveApplication";
	    }
		
		 @GetMapping("/approve/{id}/{id}")
		    public String approveLeaveApplication( @PathVariable("id") int id, Model model) {
			 LeaveRequest leaveRequest = leaveRequstService.getLeaveRequestOnId(id);
		        model.addAttribute("leaveRequest",leaveRequest);
		        return "action";
		    }

		 @PostMapping("/approvesuccess")
		 public ModelAndView ApprovedLeaveApplication(@ModelAttribute("leaveRequest")LeaveRequest leaveRequest) {	
				ModelAndView mav = new ModelAndView("successful");
				leaveRequstService.save(leaveRequest);;
				
				return mav;
			}
		 @GetMapping( "/leaveStatus")
		    public String viewLeaveStatus( Model model) {
			List<LeaveRequest> leaveRequest = leaveRequstService.allleaveRequest();
			 model.addAttribute("leaveRequest",leaveRequest);
			return "viewLeaveStatus";
		    }
}
