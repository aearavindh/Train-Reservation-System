package com.wipro.trs.service;

import com.wipro.trs.bean.*;
import com.wipro.trs.dao.TrainDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainService {
   public List<TrainBean> checkAvailability(AvailabilityBean ab) throws SQLException{
	   
	   TrainDAO trainDao = new TrainDAO();
	   List<TrainBean> al = new ArrayList<>();
	   al= trainDao.checkAvailability(ab);
	   return al;
   }
   public int addPassengers(String uname,int tno,List<PassengerBean> pbl,AvailabilityBean ab,FareBean fb) throws SQLException {
	   TrainDAO trainDao = new TrainDAO();
	   int id = trainDao.addPassengers(uname,tno,pbl,ab,fb);
	   return id;
   }
   public SeatBean availableSeats(String tno,Date date) throws SQLException {
	   TrainDAO trainDao = new TrainDAO();
	   SeatBean sb = trainDao.availableSeats(tno,date);
	   return sb;
   }
   public List<TicketBean> getTickets(String uname,int st) throws SQLException {
	   TrainDAO trainDao = new TrainDAO();
	   List<TicketBean> tb = new ArrayList<>();
	   tb = trainDao.getTickets(uname,st);
	   return tb;
   }
   public void cancelTicket(int ticketNo,String uname) throws SQLException {
	   TrainDAO trainDao = new TrainDAO();
	   trainDao.cancelTicket(ticketNo,uname);
   }
}
   
   
