package com.nasim.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee_information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String username;
	
	private String password;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Department departments;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Role roles;
	/*
	 * @Column(nullable=false) private String profilePic;
	 * 
	 * @Column(nullable=false)
	 * 
	 * @Transient private MultipartFile userImage;
	 */
	
	
	
	
	public Employee_information(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}



	public Employee_information() {
		super();
	}

	

	

	

	

}