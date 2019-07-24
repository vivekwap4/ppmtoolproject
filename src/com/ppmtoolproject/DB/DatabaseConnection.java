package com.ppmtoolproject.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
protected static Connection conn = null;
	
	private static String url = "jdbc:mysql://den1.mysql6.gear.host:3306/ppmtoolproject";
	private static String user = "ppmtoolproject";
	private static String password = "Wc1dHw?2U!z9";
	
	static {
		try {
			Class<?> c = Class.forName("com.mysql.jdbc.Driver");
			c.newInstance();
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection connect() {
		return conn;
	}
	
	public static PreparedStatement createPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

}
