package com.expedia.pshingavi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.expedia.pshingavi.model.Circle;

@Component
public class JdbcDaoImpl {

	//@Autowired ask spring to set from setter method
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;	// Not ideal place to initialize the template
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// Long long method implementation
	/*public Circle getCircle(int circleId) {
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
	}*/
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());	// Can be configured on bean creation rather than in this method, see dataSource setter
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		// Use of row mapper
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES(:id,:name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		this.namedParameterJdbcTemplate.update(sql, namedParameters);
		//jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	// Inner class mapper
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
