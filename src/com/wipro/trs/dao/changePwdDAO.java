package com.wipro.trs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.trs.bean.changePwdBean;
import com.wipro.trs.util.DBUtill;

public class changePwdDAO {
	public int changePwd(changePwdBean CB) {
		int count = 0;
		try {			
			Connection connection = DBUtill.getDBConnection();
			String uname=CB.getUname();
			System.out.println(uname);
			String pass=CB.getPass();
			System.out.println(pass);
			String opass=CB.getOpass();
			System.out.println(opass);
			String query = "update registration_table set Pass = '"+pass+"' where Uname = '"+uname+"' and Pass = '"+opass+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
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
