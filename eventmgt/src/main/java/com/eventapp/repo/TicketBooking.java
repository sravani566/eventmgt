package com.eventapp.repo;

  

public class TicketBooking {

	private int eId;
	private int totalNoOfTickets;
	public TicketBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketBooking(int eId, int totalNoOfTickets) {
		super();
		this.eId = eId;
		this.totalNoOfTickets = totalNoOfTickets;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getTotalNoOfTickets() {
		return totalNoOfTickets;
	}
	public void setTotalNoOfTickets(int totalNoOfTickets) {
		this.totalNoOfTickets = totalNoOfTickets;
	}
	
	
}

