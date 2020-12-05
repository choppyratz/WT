package by.choppyratz.quizApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import by.choppyratz.quizApp.bean.Statistics;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.bean.Quiz;

public class StatisticsDAO extends DAO {
	public StatisticsDAO() {
		super();
	}
	
	
	public Statistics getStatisticsByTestAndUserId(Quiz test, User user) {
		Connection connection = getConnection();
		Statistics stat = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM statistics WHERE test_id=? AND user_id=?");
			preparedStatement.setInt(1, test.getId());
			preparedStatement.setInt(2, user.getId());
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if(resultSet.next()){
	        	stat = new Statistics();
	        	stat.setTrueVariants(resultSet.getString(4));
	        	stat.setQuiz(test);
	        	stat.setUser(user);
	        }
	        return stat;
		}catch (Exception e) {
			return null;
		}
	}
	
	public void insertStatistics(int testId, int userId, String trueVariants) {
		Connection connection = getConnection();
		try { 
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO statistics (test_id, user_id, true_variants, time) VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, testId);
			preparedStatement.setInt(2, userId);
			preparedStatement.setString(3, trueVariants);
			preparedStatement.setString(4, "");
			preparedStatement.executeUpdate();
		}catch (Exception e) {

		}
	}

}
