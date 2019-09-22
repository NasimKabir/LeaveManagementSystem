package com.nasim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasim.model.Event;

public interface EventJpaRepository extends JpaRepository<Event, Long> {
	
}
