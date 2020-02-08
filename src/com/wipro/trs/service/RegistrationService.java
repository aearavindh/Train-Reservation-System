package com.wipro.trs.service;

import com.wipro.trs.bean.RegistrationBean;
import com.wipro.trs.dao.RegistrationDAO;

public class RegistrationService {
	 public String ServiceRegistration(RegistrationBean RB) {
		   //Validation
		   //If validations are success then call dao
		   String status = "";
		   RegistrationDAO RD = new RegistrationDAO();
		   int count = RD.Register(RB);
		   System.out.println(RB.toString());
		   if(count == 1)
			   status = "Success";
		   else
			   status = "Fail";
		   return status;
			
	   }
	 public String LoginService(String uname,String pass)
	 {
		 String status="";
		 RegistrationDAO RD=new RegistrationDAO();
		 int count=RD.Login(uname,pass);
		 if(count==1)
			 status="Success";
		 else
			 status="Fail";
		 return status;
	 }
	 public RegistrationBean forgotPwdService(String uname1)
	 {
		 RegistrationDAO RD=new RegistrationDAO();
		 RegistrationBean RB=RD.forgotPwd(uname1);
		 return RB;
	 }
	 public String CngPwd(String uname1,String pass1)
	 {
		 String status="";
		 RegistrationDAO RD=new RegistrationDAO();
		 int count=RD.CngPwd(uname1,pass1);
		 if(count==1)
			 status="Success";
		 else
			 status="Fail";
		 return status;
	 }

}
