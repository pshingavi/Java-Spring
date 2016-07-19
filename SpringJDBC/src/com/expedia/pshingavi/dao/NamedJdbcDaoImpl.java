package com.expedia.pshingavi.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedJdbcDaoImpl extends NamedParameterJdbcTemplate{

	public NamedJdbcDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	public String getCircleNameForId(int id) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		return queryForObject(sql, namedParameters, String.class);
	}

}
