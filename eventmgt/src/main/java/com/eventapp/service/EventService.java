package com.eventapp.service;
import java.time.LocalDate;
import java.util.*;

import com.eventapp.repo.BookingResponse;
import com.eventapp.repo.Event;
import com.eventapp.repo.TicketBooking;
import com.eventapp.repo.TicketCancelResponse;
import com.eventapp.repo.TicketCancelling;
public interface EventService {

	
	public List<Event> getAllEvents();
	public Event getEventById(int eId);
	public Event getEventByName(String eName);
	public Event addEvent(Event event);
	public Event updateEvent(int eId,Event event);
	public Event deleteEvent(int eId);
	public BookingResponse bookTickets(TicketBooking request);
	public TicketCancelResponse canceltickets(TicketCancelling cancel);
	public List<Event> findByEventName(String eName);

}

