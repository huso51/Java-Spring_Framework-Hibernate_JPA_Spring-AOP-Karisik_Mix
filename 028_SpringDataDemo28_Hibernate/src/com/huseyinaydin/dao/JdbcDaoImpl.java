package com.huseyinaydin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.huseyinaydin.model.Circle;

@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/*public Circle getCircle(int circleId) {
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM circle where id = ?");
			preparedStatement.setInt(1, circleId);
			Circle circle = null;
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				circle = new Circle(circleId, resultSet.getString("name"));
			}
			resultSet.close();
			preparedStatement.close();
			return circle;
		} catch (Exception ex) {
			throw new RuntimeException("Hata");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}*/
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String getCircleName(int circleId) {
		String sql = "SELECT name FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
	}
	
	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		String sql = "SELECT * FROM circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	/*
	 * public void insertCircle(Circle circle) { String sql =
	 * "INSERT INTO circle(id,name) VALUES(?,?)"; jdbcTemplate.update(sql, new
	 * Object[] {circle.getId(),circle.getName()}); }
	 */
	
	public void insertCircle(Circle circle) { 
		String sql = "INSERT INTO circle(id,name) VALUES(:id,:name)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE triangle (id INTEGER, name VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle(rs.getInt("id"), rs.getString("name"));
			return circle;
		}
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
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
