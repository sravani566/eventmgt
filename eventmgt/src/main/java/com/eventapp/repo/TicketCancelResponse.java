package com.eventapp.repo;



public class TicketCancelResponse {

	
	private String message;
	private double amountRefund;
	public TicketCancelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketCancelResponse(String message, double amountRefund) {
		super();
		this.message = message;
		this.amountRefund = amountRefund;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmountRefund() {
		return amountRefund;
	}
	public void setAmountRefund(double amountRefund) {
		this.amountRefund = amountRefund;
	}
	
	
	
}
