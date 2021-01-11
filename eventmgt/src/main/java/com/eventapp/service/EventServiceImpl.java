

  
package com.eventapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.exceptions.ResourceNotFoundException;
import com.eventapp.repo.BookingResponse;
import com.eventapp.repo.Event;
import com.eventapp.repo.TicketBooking;
import com.eventapp.repo.TicketCancelResponse;
import com.eventapp.repo.TicketCancelling;
import com.eventapp.repos.EventRepos;

@Service
@Transactional
public class EventServiceImpl implements EventService{

	
	private EventRepos eRepo;
	@Autowired
	public EventServiceImpl(EventRepos eRepo) {
		this.eRepo = eRepo;
	}

	@Override
	public List<Event> getAllEvents() {
		return eRepo.findAll();
	}

	@Override
	public Event getEventById(int eId) {
		return eRepo.findById(eId).orElseThrow(()->new ResourceNotFoundException("Data was not found"));
	}

	@Override
	public Event getEventByName(String eName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addEvent(Event event) {
		eRepo.save(event);
		return event;
	}

	@Override
	public Event updateEvent(int eId, Event event) {
		Event eventUpdate=getEventById(eId);
		eventUpdate.setePrice(event.getePrice());
		eventUpdate.setNoOfTickets(event.getNoOfTickets());
		eRepo.save(eventUpdate);
		return eventUpdate;
	}

	@Override
	public Event deleteEvent(int eId) {
		Event eventDelete=getEventById(eId);
		eRepo.delete(eventDelete);
		return eventDelete;
	}

	@Override
	public List<Event> findByEventName(String eName){
		return eRepo.findByEventName(eName);
	}

	

	@Override
	public BookingResponse bookTickets(TicketBooking request) {
		BookingResponse response=new BookingResponse();
		Event eventToBook=getEventById(request.geteId());
		if(request.getTotalNoOfTickets()>eventToBook.getNoOfTickets()) {
			response.setMessage("You can book your tickets");
			response.setAmountPayable(0.0);
		}
		else {
			eventToBook.setNoOfTickets(eventToBook.getNoOfTickets()-request.getTotalNoOfTickets());
			this.updateEvent(eventToBook.getId(),eventToBook);
			response.setMessage("Ticket Booked successfully");
			double pricePayment=(eventToBook.getePrice()*request.getTotalNoOfTickets())*
					(100-eventToBook.getDiscount())/100;
			response.setAmountPayable(pricePayment);
		}
		return response;
	}

	@Override
	public TicketCancelResponse canceltickets(TicketCancelling cancel) {
		TicketCancelling response=new TicketCancelling();
		Event eventToCancel=getEventById(cancel.geteId());
		if(eventToCancel==null) {
			throw new ResourceNotFoundException("not found");
		}
		eventToCancel.setNoOfTickets(eventToCancel.getNoOfTickets()+cancel.getTotalNoOfTickets());
		double amountReturned=((eventToCancel.getePrice()*eventToCancel.getNoOfTickets())*
				(100-eventToCancel.getDiscount())/100)*0.5;
		TicketCancelResponse cancelResponse=new TicketCancelResponse();
		cancelResponse.setAmountRefund(amountReturned);
		cancelResponse.setMessage("tickets are cancelled");
		return cancelResponse;
	}

}
