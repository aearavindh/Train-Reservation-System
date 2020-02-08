package com.wipro.trs.bean;

public class changePwdBean {
	private String uname;
	private String opass;
	private String pass;
	private String cpass;
	
	public changePwdBean() {
		super();
	}
	
	public changePwdBean(String uname,String opass,String pass,String cpass) {
		this.uname=uname;
		this.opass=opass;
		this.pass=pass;
		this.cpass=cpass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getOpass() {
		return opass;
	}

	public void setOpass(String opass) {
		this.opass = opass;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	
}
