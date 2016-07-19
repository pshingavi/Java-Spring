package com.expedia.pshingavi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.expedia.pshingavi.model.Circle;

@Component
public class JdbcDaoImpl {

	//@Autowired ask spring to set from setter method
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();	// Not ideal place to initialize the template


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
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());	// Can be configured on bean creation rather than in this method, see dataSource setter
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
