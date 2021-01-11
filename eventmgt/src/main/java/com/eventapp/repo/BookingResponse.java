package com.eventapp.repo;


  

public class BookingResponse {

	
	private String message;
	private double amountPayable;
	public BookingResponse(String message, double amountPayable) {
		super();
		this.message = message;
		this.amountPayable = amountPayable;
	}
	public BookingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}
	
	
}

