package com.eventapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.repo.Event;
@Repository
public interface EventRepo extends JpaRepository<Event,Integer>{
	
}