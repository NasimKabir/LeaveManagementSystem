package com.nasim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.LeavePolicy;
import com.nasim.repository.LeavePolicyRepository;

@Service
public class LeavePolicyService {
	@Autowired
	private LeavePolicyRepository userpolicyRepo;

	// create a leave policies
	public void createLeavePolicy(LeavePolicy policy) {
		userpolicyRepo.save(policy);
	}
}
