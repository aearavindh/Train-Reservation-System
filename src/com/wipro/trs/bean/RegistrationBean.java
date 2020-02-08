package com.wipro.trs.bean;

import java.sql.Date;

public class RegistrationBean {
	private String uname;
	private String pass;
	private String cpass;
	private String fname;
	private String lname;
	private String addr;
	private String nationality;
	private String gender;
	private Date dob;
	private long mobno;
	private String email;
	private String securityQues;
	private String securityAns;
	public RegistrationBean() {
		super();
	}
	
	public RegistrationBean(String uname,String pass,String cpass,String fname,String lname,String address,String nationality,String gender,Date dob,long mobno,String email,String securityQues,String securityAns)
	{
		super();
		this.uname=uname;
		this.pass=pass;
		this.cpass=cpass;
		this.fname=fname;
		this.lname=lname;
		this.addr=address;
		this.nationality=nationality;
		this.gender=gender;
		this.dob=dob;
		this.mobno=mobno;
		this.email=email;
		this.securityQues=securityQues;
		this.securityAns=securityAns;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public String getCpass() {
		return cpass;
	}

	public String getSecurityQues() {
		return securityQues;
	}

	public void setSecurityQues(String securityQues) {
		this.securityQues = securityQues;
	}

	public String getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "RegistrationBean [uname=" + uname + ", pass=" + pass + ", cpass=" + cpass + ", fname=" + fname
				+ ", lname=" + lname + ", addr=" + addr + ", nationality=" + nationality + ", gender=" + gender
				+ ", dob=" + dob + ", mobno=" + mobno + ", email=" + email + ",securityQues="+ securityQues +",securityAns="+ securityAns +"]";
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}

