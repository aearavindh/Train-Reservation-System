package com.wipro.trs.bean;

public class PassengerBean {
     private String name;
     private int age;
     private String gender;
     private String classOfTravel;
	public PassengerBean(String name, int age, String gender, String classOfTravel) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.setClassOfTravel(classOfTravel);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassOfTravel() {
		return classOfTravel;
	}
	public void setClassOfTravel(String classOfTravel) {
		this.classOfTravel = classOfTravel;
	}
	
     
}
