package com.expedia.pshingavi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.expedia.pshingavi.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int circleId) {
		Connection con = null;
		// Init client driver
		try{
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			
			PreparedStatement ps = con.prepareStatement("SELECT * from circle where id = ?");
			ps.setInt(1,  circleId);
			Circle circle = null;
			
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				circle = new Circle(circleId, result.getString("name"));
			}
			return circle;
		} catch(Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
}
