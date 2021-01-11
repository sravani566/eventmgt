package com.eventapp.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.repo.EventUser;
import com.eventapp.repos.EventUserRepo;

@Service
@Transactional
public class EventUserServiceImpl implements EventUserService{

	private EventUserRepo userRepo;
	
	@Autowired
	public EventUserServiceImpl(EventUserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public EventUser addUser(EventUser users) {
		userRepo.save(users);
		return users;
	}

	@Override
	public EventUser findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}

