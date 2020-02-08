package com.wipro.trs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.trs.bean.RegistrationBean;
import com.wipro.trs.bean.changePwdBean;
import com.wipro.trs.service.RegistrationService;
import com.wipro.trs.service.changePwdService;


public class RegistrationController extends HttpServlet{
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
		
		String trigerFrom = req.getParameter("trsButton");
		PrintWriter out=resp.getWriter();
		if (trigerFrom.equals("Sign Up")) 
		{
			String uname = req.getParameter("uname");
			String pass = req.getParameter("pass");
			String cpass = req.getParameter("cpass");
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String gender = req.getParameter("gender");
			Date date=Date.valueOf(req.getParameter("date"));
			long mobno = Long.parseLong(req.getParameter("mobno"));
			String email = req.getParameter("email");
			String securityQues=req.getParameter("securityQues");
			String securityAns=req.getParameter("securityAns");
			String address = req.getParameter("address");
			String nationality = req.getParameter("nationality");
			System.out.println(uname);
		RegistrationBean rb=new RegistrationBean();
		rb.setAddr(address);
		rb.setCpass(cpass);
		rb.setDob(date);
		rb.setEmail(email);
		rb.setFname(fname);
		rb.setGender(gender);
		rb.setLname(lname);
		rb.setMobno(mobno);
		rb.setNationality(nationality);
		rb.setPass(pass);
		rb.setUname(uname);
		rb.setSecurityQues(securityQues);
		rb.setSecurityAns(securityAns);
		RegistrationService RS=new RegistrationService();
		String status=RS.ServiceRegistration(rb);
		if(status.equals("Success"))
			resp.sendRedirect("LandingPage.jsp");
		else {
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.include(req,resp);
			out.println("<center>Username already exists</center>");
		}
        }else if(trigerFrom.equals("Login"))
		{
        	HttpSession session = req.getSession();
			String uname = req.getParameter("uname");
			String pass = req.getParameter("pass");
			RegistrationService RS=new RegistrationService();
			String status=RS.LoginService(uname,pass);
			if(status.equals("Success")) {                           
				session.setAttribute("username", uname);
				resp.sendRedirect("Enquiry.jsp");
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
				out.println("<center>Invalid Username or Password</center>");
			}
		}else if(trigerFrom.equals("Submit"))
		{
			String username=req.getParameter("uname1");
			HttpSession session = req.getSession();
			session.setAttribute("uname", username);
			RegistrationService RS=new RegistrationService();
			RegistrationBean tb=RS.forgotPwdService(username);
			System.out.println(tb.getSecurityQues());
			System.out.println(tb.getSecurityAns());
			if(tb.getSecurityQues()==null){
				session.setAttribute("status", "invalid");
				req.getRequestDispatcher("/forgotpwd.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("RegistrationBean",tb);
				session.setAttribute("ans",tb.getSecurityAns());
				req.getRequestDispatcher("/forgotPwd2.jsp").forward(req, resp);
				
				}
			
		}else if (trigerFrom.equals("submit")) 
		{
			String uname = req.getParameter("uname");
			String opass=req.getParameter("Opass");
			String pass = req.getParameter("Npass");
			String cpass = req.getParameter("Conpass");
			changePwdBean cb=new changePwdBean();
			cb.setUname(uname);
			cb.setOpass(opass);
			cb.setPass(pass);
			cb.setCpass(cpass);
			
			
			changePwdService cs=new changePwdService();
			String status=cs.changePwd(cb);
			if(status.equals("Success")) {
				out.println("password is changed successfully");
				resp.sendRedirect("Welcome.jsp");
			}
			else {
			RequestDispatcher rd=req.getRequestDispatcher("changepwd.jsp");
			rd.include(req, resp);
		    out.println("<center>invalid username or password</center>");
			}
		}else if(trigerFrom.equals("Submit Answer"))
		{
			HttpSession session = req.getSession();
			String secAns=(String)session.getAttribute("ans");
			System.out.println(secAns);
			String securityAnswer=req.getParameter("securityAns");
			if(secAns.equals(securityAnswer))
				req.getRequestDispatcher("CngPwd.jsp").forward(req, resp);
			else
			{
				session.setAttribute("flag", "invalid");
				req.getRequestDispatcher("/forgotPwd2.jsp").forward(req, resp);
		}
		}else if(trigerFrom.equals("change password"))
		{
			HttpSession session = req.getSession();
			String uname1=(String)session.getAttribute("uname");
			System.out.println(uname1);
			String pass1=req.getParameter("pass1");
			String pass2=req.getParameter("pass2");
			RegistrationService RS=new RegistrationService();
			String status=RS.CngPwd(uname1,pass1);
			if(status.equals("Success"))
			{
				out.println("Successfully changed password");
				resp.sendRedirect("LandingPage.jsp");
			}
			
			
		}
}
}

