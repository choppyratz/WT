package by.choppyratz.quizApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/wt_quiz?serverTimezone=Europe/Minsk&useSSL=false";
	private  String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
