package by.choppyratz.quizApp.dao;

import by.choppyratz.quizApp.dao.DAO;
import java.sql.*;
import by.choppyratz.quizApp.bean.User;
import java.security.MessageDigest;

public class UserDAO extends DAO {
	public UserDAO() {
		super();
	}
	
	public User getUser(String remeberToken) {
		Connection connection = getConnection();
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE remeber_token=?");
			preparedStatement.setString(1, remeberToken);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if(resultSet.next()){
	        	user = new User();
	        	user = user.setEmail(resultSet.getString(2));
	        	user = user.setPassword(resultSet.getString(5));
	        	user = user.setRememberToken(resultSet.getString(7));
	        	user = user.setRoleId(resultSet.getInt(6));
	        	user = user.setName(resultSet.getString(3));
	        	user = user.setSurname(resultSet.getString(4));
	        }
	        return user;
		}catch (Exception e) {
			return null;
		}
	}
	
	public User getUser(String email, String password) {
		Connection connection = getConnection();
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if(resultSet.next()){
	        	user = new User();
	        	user = user.setEmail(resultSet.getString(2));
	        	user = user.setPassword(resultSet.getString(5));
	        	user = user.setRememberToken(resultSet.getString(7));
	        	user = user.setRoleId(resultSet.getInt(6));
	        	user = user.setName(resultSet.getString(3));
	        	user = user.setSurname(resultSet.getString(4));
	        }
	        return user;
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public User insertUser(User user) {
		Connection connection = getConnection();
		try { 
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (email, name, surname, password, role_id) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, new String(user.getName().getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setString(3, new String(user.getSurname().getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setString(4, new String(user.getPassword().getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setInt(5, 1);
			preparedStatement.executeUpdate();
			return user;
		}catch (Exception e) {
			return user;
		}
	}
	
	public void updateUser(User user) {
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET remeber_token=? WHERE email=?");
			preparedStatement.setString(1, user.getRememberToken());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			
		}
	}
	
	
	public void deleteUser(User user) {
		
	}
	
}
