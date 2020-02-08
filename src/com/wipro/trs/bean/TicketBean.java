package com.wipro.trs.bean;

import java.sql.Date;

public class TicketBean {
	private int ticketNo;
	private int bookingId;
	private String name;
	private String gender;
	private int age;
	private int tNumber;
	private String tName;
	private String from;
	private String to;
	private int amount;
	private Date dateOfTravel;
	private Date dateOfBooking;
	private String status;
	public TicketBean(int ticketNo, int bookingId, String name, String gender, int age, int tNumber, String tName, String from,
			String to, int amount, Date dateOfTravel, Date dateOfBooking, String status) {
		super();
		this.ticketNo = ticketNo;
		this.bookingId = bookingId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.tNumber = tNumber;
		this.tName = tName;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.dateOfTravel = dateOfTravel;
		this.dateOfBooking = dateOfBooking;
		this.status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int gettNumber() {
		return tNumber;
	}
	public void settNumber(int tNumber) {
		this.tNumber = tNumber;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(Date dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
