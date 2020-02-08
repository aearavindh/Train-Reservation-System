package com.wipro.trs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.trs.bean.RegistrationBean;
import com.wipro.trs.util.DBUtill;

public class RegistrationDAO {
	public int Register(RegistrationBean RB) {
		int count = 0;
		try {			
			Connection connection = DBUtill.getDBConnection();
			String query = "insert into Registration_table values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, RB.getUname());
			preparedStatement.setString(2, RB.getPass());
			preparedStatement.setString(3, RB.getCpass());
			preparedStatement.setString(4, RB.getFname());
			preparedStatement.setString(5, RB.getLname());
			preparedStatement.setString(6, RB.getGender());
			preparedStatement.setDate(7, (Date) RB.getDob());
			preparedStatement.setString(8, RB.getEmail());
			preparedStatement.setLong(9, RB.getMobno());
			preparedStatement.setString(10, RB.getSecurityQues());
			preparedStatement.setString(11, RB.getSecurityAns());
			preparedStatement.setString(12, RB.getNationality());
			preparedStatement.setString(13, RB.getAddr());
			count = preparedStatement.executeUpdate();
			if(count!=0) {
				query="create table "+RB.getUname()+"(id number(6),name char(30),gender char(6),age number(3),tnumber number(5),tname varchar2(50),fromstation varchar2(10),tostation varchar2(10),amount number(6),dateoftravel date,dateofbooking date,status char(10),tno number(3),primary key(tno))";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(count);
		return count;
	}
	public int Login(String uname,String pass)
	{
		int count = 0;
		try {			
			Connection connection = DBUtill.getDBConnection();
			String query = "select Uname,Pass from Registration_table where Uname='"+uname+"' and Pass='"+pass+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				count=1;
			resultSet.close();
			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e);
		}
		return count;
	}
	public RegistrationBean forgotPwd(String uname1)
	{
		RegistrationBean tb=new RegistrationBean();
		try {
			Connection con=DBUtill.getDBConnection();
			String query="select securityQues,securityAns from Registration_table where Uname='"+uname1+"'";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				tb.setSecurityQues(rs.getString("securityQues"));
				tb.setSecurityAns(rs.getString("securityans"));
			}
			rs.close();
		}catch(Exception e) {
		
		} 
		return tb;
	}
	public int CngPwd(String uname1,String pass1)
	{
		int count=0;
		try {
		Connection con=DBUtill.getDBConnection();
		String uname=uname1;
		String pass=pass1;
		String query = "Update registration_table SET Pass = '"+pass+"' WHERE Uname='"+uname+"'";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		int resultSet = preparedStatement.executeUpdate();
		if(resultSet>0)
			count=1;
		System.out.println(count);
	} catch (Exception e) {
		System.out.println(e);
	}
	return count;

	}
}

		
		
	

