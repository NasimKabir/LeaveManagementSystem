package com.nasim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.LeaveRequest;
import com.nasim.repository.LeaveRequestRepository;

@Service
public class LeaveService {
	@Autowired
	private LeaveRequestRepository leaveRequest;

	public void save(LeaveRequest leave) {
		leaveRequest.save(leave);
	}

	public List<LeaveRequest> allleaveRequest() {
		return leaveRequest.findAll();

	}
	
	public LeaveRequest getLeaveRequestOnId(int id) {
		LeaveRequest result = leaveRequest.findById(id).get();
		return result;
	    }
	
	
	public List<LeaveRequest> allLeaveStatus(){
		return leaveRequest.findAll();
	}
}
