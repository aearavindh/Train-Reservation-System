package com.wipro.trs.bean;

public class TrainBean {
   private int tNumber;
   private String tName;
   private String arrivalTime;
   private String departureTime;
   private int sleeperFare;
   private int acFare;
   public TrainBean() {
	   
   }
public TrainBean(int tNumber, String tName, String arrivalTime, String departureTime, int sleeperFare, int acFare) {
	super();
	this.tNumber = tNumber;
	this.tName = tName;
	this.arrivalTime = arrivalTime;
	this.departureTime = departureTime;
	this.sleeperFare = sleeperFare;
	this.acFare = acFare;
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
public String getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(String arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public String getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(String departureTime) {
	this.departureTime = departureTime;
}
public int getSleeperFare() {
	return sleeperFare;
}
public void setSleeperFare(int sleeperFare) {
	this.sleeperFare = sleeperFare;
}
public int getAcFare() {
	return acFare;
}
public void setAcFare(int acFare) {
	this.acFare = acFare;
}
@Override
public String toString() {
	return "TrainBean [tNumber=" + tNumber + ", tName=" + tName + ", arrivalTime=" + arrivalTime + ", departureTime="
			+ departureTime + ", sleeperFare=" + sleeperFare + ", acFare=" + acFare + "]";
}

}
