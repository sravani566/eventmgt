package com.eventapp.service;


import com.eventapp.repo.EventUser;

public interface EventUserService {
	
	public EventUser addUser(EventUser users);
	public EventUser findByUsername(String username);

}
