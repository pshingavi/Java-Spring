package com.pshingavi.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.pshingavi.spring.model.Offer;

@Component("offersDAO")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(resultSet.getInt("id"));
				offer.setName(resultSet.getString("name"));
				offer.setEmail(resultSet.getString("email"));
				offer.setText(resultSet.getString("text"));
				return offer;
			}
			
		});
	}
	
	public Offer getOfferById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(resultSet.getInt("id"));
				offer.setName(resultSet.getString("name"));
				offer.setEmail(resultSet.getString("email"));
				offer.setText(resultSet.getString("text"));
				return offer;
			}
		});
	}
}
