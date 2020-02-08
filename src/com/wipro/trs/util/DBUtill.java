package com.wipro.trs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {
	public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
