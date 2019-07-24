package com.ppmtoolproject.DBTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ppmtoolproject.DB.DatabaseConnection;

public class DBTest extends DatabaseConnection{
	public static void main(String[] args) {
		String sql = "Insert into test values (?,?)";
		PreparedStatement ps = createPreparedStatement(sql);
		
		try {
			ps.setInt(1, 1);
			ps.setString(2,  "Test Value 1");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
