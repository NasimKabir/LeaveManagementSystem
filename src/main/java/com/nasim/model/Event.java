package com.nasim.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Event {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title; 
	private String description;
	private LocalDateTime start; 
	private LocalDateTime finish;
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
