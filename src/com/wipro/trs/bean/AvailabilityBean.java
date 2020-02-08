package com.wipro.trs.bean;

import java.sql.Date;

public class AvailabilityBean {
   private String from;
   private String to;
   private Date date;
   
   public AvailabilityBean(String from, String to, Date date) {
	super();
	this.from = from;
	this.to = to;
	this.date = date;
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
