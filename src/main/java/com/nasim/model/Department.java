package com.nasim.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depart_id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employee_information emp;

	@Override
	public String toString() {
		return "Department [depart_id=" + depart_id + ", name=" + name + ", emp=" + emp + "]";
	}

}
