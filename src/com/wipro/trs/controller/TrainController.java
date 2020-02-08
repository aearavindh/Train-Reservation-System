package com.wipro.trs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wipro.trs.service.TrainService;
import com.wipro.trs.bean.TrainBean;
import com.wipro.trs.bean.AvailabilityBean;
import com.wipro.trs.bean.FareBean;
import com.wipro.trs.bean.PassengerBean;
import com.wipro.trs.bean.SeatBean;
import com.wipro.trs.bean.TicketBean;


public class TrainController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out = resp.getWriter();
		String trigerFrom = req.getParameter("trsButton");
		if(trigerFrom.length()<=3) {
			HttpSession session = req.getSession();
			int ticketNo = Integer.parseInt(trigerFrom);
			TrainService ts = new TrainService();
			try {
				ts.cancelTicket(ticketNo,(String)session.getAttribute("username"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			trigerFrom = "CANCEL TICKET";
	    }

		if(trigerFrom.equals("BOOKING HISTORY") || trigerFrom.equals("UPCOMING TRAVEL") || trigerFrom.equals("CANCEL TICKET")) {
			HttpSession session = req.getSession();
			String uname = (String)session.getAttribute("username");
			List<TicketBean> tb = new ArrayList<>();
			TrainService ts = new TrainService();
			int st=0;
			if(trigerFrom.equals("BOOKING HISTORY"))
				st=0;
			else
				st=1;
			try {
				tb = ts.getTickets(uname,st);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("Tickets", tb);
			if(trigerFrom.equals("BOOKING HISTORY"))
			   req.getRequestDispatcher("History.jsp").forward(req, resp);
			else if(trigerFrom.equals("UPCOMING TRAVEL"))
			   req.getRequestDispatcher("Travel.jsp").forward(req, resp);
			else if(trigerFrom.equals("CANCEL TICKET"))
			   req.getRequestDispatcher("Cancel.jsp").forward(req, resp);
			
		}else if (trigerFrom.equals("CHECK AVAILABILITY")) {
			String from = req.getParameter("from");
			String to = req.getParameter("to");
		    Date date = Date.valueOf(req.getParameter("date"));
            
		    AvailabilityBean ab = new AvailabilityBean(from,to,date);
			TrainService ts = new TrainService();
			List<TrainBean> al = new ArrayList<>();
			try {
				al = ts.checkAvailability(ab);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    HttpSession session = req.getSession();
		    session.setAttribute("ab", ab);
		    session.setAttribute("TrainArray", al);
		    req.getRequestDispatcher("Availability.jsp").forward(req, resp);
		}else if(trigerFrom.equals("BOOK")) {
			HttpSession session = req.getSession();
			List<PassengerBean> pbl = new ArrayList<>();
			int n = (int)session.getAttribute("passengers");
			
			int st=0;
			for(int i=1;i<=n;i++) {
				if(req.getParameter("name"+i)==null || req.getParameter("age"+i)==null || req.getParameter("gender"+i)==null || req.getParameter("class"+i)==null)
					st=1;
			}
			if(st==0) {
			for(int i=1;i<=n;i++) {
				pbl.add(new PassengerBean(req.getParameter("name"+i),Integer.parseInt(req.getParameter("age"+i)),req.getParameter("gender"+i),req.getParameter("class"+i)));
			}
			String uname = (String)session.getAttribute("username");
			int tno = Integer.parseInt((String)session.getAttribute("trainNo"));
			List<TrainBean> tbl = (List<TrainBean>)session.getAttribute("TrainArray");
			int i;
			for(i=0;i<tbl.size();i++) {
				if((tbl.get(i)).gettNumber()==tno)
					break;
			}
			FareBean fb = new FareBean((tbl.get(i)).getSleeperFare(),(tbl.get(i)).getAcFare());
			
			
			TrainService ts = new TrainService();
			AvailabilityBean ab = (AvailabilityBean)session.getAttribute("ab");
			int id = 0;
			try {
				id = ts.addPassengers(uname,tno,pbl,ab,fb);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("BookingId", id);
			req.getRequestDispatcher("BookingSuccess.jsp").forward(req, resp);
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("Booking.jsp");
				rd.include(req,resp);
				out.println("<center>Enter all the details</center>");
			}
			}else if(trigerFrom.equals("LOGOUT")) {
		    	HttpSession session = req.getSession();
		    	session.removeAttribute("username");
		    	session.invalidate();
		    	resp.sendRedirect("LandingPage.jsp");
		    } else {
			HttpSession session = req.getSession();
			AvailabilityBean ab = (AvailabilityBean)session.getAttribute("ab");
			TrainService ts = new TrainService();
			SeatBean sb = null;
			try {
				sb = ts.availableSeats(trigerFrom,ab.getDate());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("trainNo", trigerFrom);
			session.setAttribute("SeatBean", sb);
			req.getRequestDispatcher("BookingFrame.jsp").forward(req, resp);
			
		}
	}

}

