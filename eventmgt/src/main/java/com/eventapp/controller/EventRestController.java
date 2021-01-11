package com.eventapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.repo.Event;
import com.eventapp.service.EventService;
import java.util.*;
@RestController
@RequestMapping("/admin")
public class EventRestController {
	
	@Autowired
	private EventService eService;
	

	public EventRestController(EventService eService) {
		this.eService = eService;
	}

	@GetMapping(path="/alevent",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> getEvents() {
		List<Event> allevents=eService.getAllEvents();
		return new  ResponseEntity<List<Event>>(allevents,HttpStatus.OK) ;
	}

	@GetMapping(path="/alevents/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> getEventId(@PathVariable(value="id") int id){
		Event eventId=eService.getEventById(id);
		return new ResponseEntity<Event>(eventId,HttpStatus.OK);
	}
	
	@GetMapping(path="/aleventy/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> getEventsName(@PathVariable(value="name")String eventName) {
		Event eventsByName=eService.getEventByName(eventName);
		return new  ResponseEntity<Event>(eventsByName,HttpStatus.OK) ;
	}

	@PostMapping(path="/alevents",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> getEventsAdded(@RequestBody Event event) {
		Event eventsAdded=eService.addEvent(event);
		return new  ResponseEntity<Event>(eventsAdded,HttpStatus.CREATED) ;
	}

	@PutMapping(path="/alevents/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> updatingEvent(@PathVariable(value="id") int id,@RequestBody Event event){
		Event eventToUpdate=eService.updateEvent(id, event);
		return new ResponseEntity<Event>(eventToUpdate,HttpStatus.CREATED);
	}

	@DeleteMapping(path="/alevent/{eId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> getEventsDeleted(@PathVariable(value="eId") int eId) {
		Event eventsDeleted=eService.deleteEvent(eId);
		return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT) ;
	}
	
}

