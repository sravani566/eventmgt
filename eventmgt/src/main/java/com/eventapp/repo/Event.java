package com.eventapp.repo;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_event")
public class Event {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String eventName;
   private String eLocation;
   private double ePrice;
   private LocalDate edate;
   private int discount;
   private int noOfTickets;
public Event() {
	super();
	// TODO Auto-generated constructor stub
}

public Event(String eventName, String eLocation, double ePrice, LocalDate edate, int discount, int noOfTickets) {
	super();
	this.eventName = eventName;
	this.eLocation = eLocation;
	this.ePrice = ePrice;
	this.edate = edate;
	this.discount = discount;
	this.noOfTickets = noOfTickets;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getEventName() {
	return eventName;
}

public void setEventName(String eventName) {
	this.eventName = eventName;
}

public String geteLocation() {
	return eLocation;
}
public void seteLocation(String eLocation) {
	this.eLocation = eLocation;
}
public double getePrice() {
	return ePrice;
}
public void setePrice(double ePrice) {
	this.ePrice = ePrice;
}
public LocalDate getEdate() {
	return edate;
}
public void setEdate(LocalDate edate) {
	this.edate = edate;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public int getNoOfTickets() {
	return noOfTickets;
}
public void setNoOfTickets(int noOfTickets) {
	this.noOfTickets = noOfTickets;
}
   
   
   
}
