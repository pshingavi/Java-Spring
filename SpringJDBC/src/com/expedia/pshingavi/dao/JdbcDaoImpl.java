package com.expedia.pshingavi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expedia.pshingavi.model.Circle;

@Component
public class JdbcDaoImpl {

	@Autowired
	private DataSource dataSource;
	


	public Circle getCircle(int circleId) {
		Connection con = null;
		// Init client driver
		try{
			con = dataSource.getConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * from circle where id = ?");
			ps.setInt(1,  circleId);
			Circle circle = null;
			
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				circle = new Circle(circleId, result.getString("name"));
			}
			result.close();
			ps.close();
			return circle;
		} catch(Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
