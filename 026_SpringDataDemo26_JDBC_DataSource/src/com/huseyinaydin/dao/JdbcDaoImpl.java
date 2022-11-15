package com.huseyinaydin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.huseyinaydin.model.Circle;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	public Circle getCircle(int circleId) {
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
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
