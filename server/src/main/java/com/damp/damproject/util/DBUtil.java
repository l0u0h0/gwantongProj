package com.damp.damproject.util;

import java.sql.*;

public class DBUtil {
	
	private static final String[] DRIVERS = { "com.mysql.cj.jdbc.Driver", "org.postgresql.Driver" };
	
	static {
		try {
			for (String driver : DRIVERS) Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void close(AutoCloseable... autoCloseables) {
		for(AutoCloseable ac : autoCloseables) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
