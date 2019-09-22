package com.nasim.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LeavePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String leaveType;
	
	
	
	public LeavePolicy() {
		super();
	}



	public LeavePolicy(String leaveType) {
		super();
		this.leaveType = leaveType;
	}
	
}
