package com.wipro.trs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.wipro.trs.bean.*;
import com.wipro.trs.util.DBUtill;

public class TrainDAO {

	public List<TrainBean> checkAvailability(AvailabilityBean ab) throws SQLException {
		int j=0,k=0;
			Connection connection = DBUtill.getDBConnection();
			String query = "select * from train_details where tRoute like ? or tRoute like ? or tRoute like ? or tRoute like ?";
		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    String s1 = ab.getFrom();
		    String s2 = ab.getTo();
		    String s3,s4,s5,s6,st3[],st4[],st5[],st6[];
			preparedStatement.setString(1, s1+"%"+s2);
			preparedStatement.setString(2, "%"+s1+"%"+s2+"%");
			preparedStatement.setString(3, s1+"%"+s2+"%");
			preparedStatement.setString(4, "%"+s1+"%"+s2);
	        ResultSet rs = preparedStatement.executeQuery();
	        List<TrainBean> al = new ArrayList<>();
	        while(rs.next()) {
	        	s3 = rs.getString("tRoute");
	        	s4 = rs.getString("tTime");
	        	st3 = s3.split("_");
	        	st4 = s4.split("_");
	        	for(int l=0;l<st3.length;l++) {
	        		if(s1.equals(st3[l].trim())) {
	        			j=l;
	        		}
	        		if(s2.equals(st3[l].trim())) {
	        			k=l;
	        		}
	        	}
	        	s5 = rs.getString("tFareSleeper");
	        	s6 = rs.getString("tFareAc");
	        	st5 = s5.split("_");
	        	st6 = s6.split("_");
	        	al.add(new TrainBean(rs.getInt("tNumber"),rs.getString("tName"),st4[j].substring(0,5),st4[j].substring(6),Integer.parseInt(st5[k])-Integer.parseInt(st5[j]),Integer.parseInt(st6[k])-Integer.parseInt(st6[j])));
	        }
	    
		return al;
	}
	
	public int addPassengers(String uname,int tno,List<PassengerBean> pbl,AvailabilityBean ab,FareBean fb) throws SQLException {
        
		Connection connection = DBUtill.getDBConnection();
		String query = "select tName from train_details where tNumber=?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, tno);
		ResultSet rs = stmt.executeQuery();
		String tname = null;
		if(rs.next())
			tname = rs.getString("tName");
		String from = ab.getFrom();
		String to = ab.getTo();
		Date dateOfTravel = ab.getDate();
		int sleeper = fb.getSleeper();
		int ac = fb.getAc();
		
		long millis = System.currentTimeMillis();
		Date dateOfBooking = new Date(millis);
		
		Random rnd = new Random();
		int bookingId = 100000+rnd.nextInt(900000);
		
		int slCnt=0,acCnt=0;
		
		int amount,ticketNo=0;
		query = "select count(*) from "+uname;
		stmt = connection.prepareStatement(query);
		rs = stmt.executeQuery();
		if(rs.next())
		ticketNo = rs.getInt("count(*)");
		for(int i=0;i<pbl.size();i++) {
			query = "insert into "+uname+" values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,bookingId);
			pstmt.setString(2, (pbl.get(i)).getName());
			pstmt.setString(3, (pbl.get(i)).getGender());
			pstmt.setInt(4, (pbl.get(i)).getAge());
			pstmt.setInt(5,tno);
			pstmt.setString(6, tname);
			pstmt.setString(7, from);
			pstmt.setString(8, to);
			
			if((pbl.get(i)).getClassOfTravel().equals("sleeper")) {
				amount = sleeper;
				slCnt++;
			}else {
				amount = ac;
				acCnt++;
			}
			
			pstmt.setInt(9, amount);
			pstmt.setDate(10, dateOfTravel);
			pstmt.setDate(11, dateOfBooking);
			pstmt.setString(12, "Booked");
			pstmt.setInt(13, ++ticketNo);
			pstmt.executeUpdate();
		}
		String d = String.valueOf(dateOfTravel);
		d = "t"+d.substring(0,4)+d.substring(5,7)+d.substring(8,10);
		
		query = "select * from "+d+" where tNumber = ?";
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, tno);
		rs = stmt.executeQuery();
		int slSeats=0,acSeats=0;
		if(rs.next()) {
			slSeats = rs.getInt("sleeper")-slCnt;
			acSeats = rs.getInt("ac")-acCnt;
		}
		
		query = "update "+d+" set sleeper = ? where tNumber = ?";
	    stmt = connection.prepareStatement(query);
		stmt.setInt(1, slSeats);
		stmt.setInt(2, tno);
		stmt.executeUpdate();
		
		query = "update "+d+" set ac = ? where tNumber = ?";
	    stmt = connection.prepareStatement(query);
		stmt.setInt(1, acSeats);
		stmt.setInt(2, tno);
		stmt.executeUpdate();
		
		return bookingId;
	}
	public SeatBean availableSeats(String tno,Date date) throws SQLException {
		Connection connection = DBUtill.getDBConnection();
		SeatBean sb = null;
		String d = String.valueOf(date);
		d = "t"+d.substring(0,4)+d.substring(5,7)+d.substring(8,10);
		String query="select * from "+d+" where tNumber="+tno;
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()) {
			sb = new SeatBean(rs.getInt("sleeper"),rs.getInt("ac"));
		}
		return sb;
	}
	public List<TicketBean> getTickets(String uname,int st) throws SQLException{
		Connection connection = DBUtill.getDBConnection();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		String query = null;
		PreparedStatement preparedStatement = null;
		if(st==0) {
		    query = "select * from "+uname+" order by tno asc";
		    preparedStatement = connection.prepareStatement(query);
		}else if(st==1) {
			query="select * from "+uname+" where dateOfTravel >= ? order by tno asc"; 
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setDate(1, date);
		}
		ResultSet rs = preparedStatement.executeQuery();
		List<TicketBean> tb = new ArrayList<>();
		while(rs.next()) {
			tb.add(new TicketBean(rs.getInt("tno"),rs.getInt("id"),rs.getString("name"),rs.getString("gender"),rs.getInt("age"),rs.getInt("tNumber"),rs.getString("tName"),rs.getString("fromStation"),rs.getString("toStation"),rs.getInt("amount"),rs.getDate("dateOfTravel"),rs.getDate("dateOfBooking"),rs.getString("status")));
		}
		return tb;
	}
	public void cancelTicket(int ticketNo,String uname) throws SQLException {
		Connection connection = DBUtill.getDBConnection();
		String query = "update "+uname+" set status = ? where tno=?";
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, "Cancelled");
		pstmt.setInt(2, ticketNo);
		pstmt.executeUpdate();
	}
	
}
