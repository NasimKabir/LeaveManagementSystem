package com.nasim.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roles_id;
	
	private String name;
	
	  
	public Role(String name) {
		super();
		this.name = name;
	}


	public Role() {
		super();
	}


	public Role(int roles_id, String name) {
		super();
		this.roles_id = roles_id;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Role [roles_id=" + roles_id + ", name=" + name + "]";
	}


	
	
	
}
