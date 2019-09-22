package com.nasim.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leave_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toDate;
	private String leaveType;
	private String reason;
	private int duration;

	private String comments;
	
	private String AcceptRejectFlag;
	
	@OneToOne
	private Employee_information users;
	
	public LeaveRequest(Date fromDate, Date toDate, String leaveType, String reason, int duration) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.reason = reason;
		this.duration = duration;
		
	}


	public LeaveRequest() {
		super();
	}


	public LeaveRequest(Date fromDate, Date toDate, String leaveType, String reason, int duration,
			String acceptRejectFlag, Employee_information users) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
		this.reason = reason;
		this.duration = duration;
		AcceptRejectFlag = acceptRejectFlag;
		this.users = users;
	}


	
	
	
}
