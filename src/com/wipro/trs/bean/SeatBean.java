package com.wipro.trs.bean;

public class SeatBean {
	private int sleeper;
	private int ac;
	public SeatBean(int sleeper, int ac) {
		super();
		this.sleeper = sleeper;
		this.ac = ac;
	}
	public int getSleeper() {
		return sleeper;
	}
	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	
}
