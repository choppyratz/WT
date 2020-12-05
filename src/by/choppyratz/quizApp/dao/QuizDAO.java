package by.choppyratz.quizApp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import by.choppyratz.quizApp.bean.Quiz;
import by.choppyratz.quizApp.bean.Statistics;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.dao.DAO;
import java.util.Date;
import java.text.SimpleDateFormat;


public class QuizDAO extends DAO {
	public QuizDAO() {
		super();
	}
	
	public ArrayList<Quiz> getAllQuizes() {
		Connection connection = getConnection();
		
		ArrayList<Quiz> list = new ArrayList<Quiz>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tests");
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()){
                
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String test_body = resultSet.getString(4);
                String create_date = resultSet.getString(5);
                int subject_id = resultSet.getInt(6);
                Quiz quiz = new Quiz(id, name, description, create_date, subject_id);
                list.add(quiz);
            }
	        return list;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public Quiz getQuizById(int id) {
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tests WHERE id=?");
			preparedStatement.setInt(1, id);
			Quiz quiz = null;
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if(resultSet.next()){
	        	quiz = new Quiz();
	        	quiz.setId(resultSet.getInt(1));
	        	quiz.setName(resultSet.getString(2));
	        	quiz.setDescription(resultSet.getString(3));
	        	quiz.setTestBody(resultSet.getString(4));
	        	quiz.setAnswers(resultSet.getString(7));
	        }
	        return quiz;
		}catch (Exception e) {
			return null;
		}
	}
	
	public ArrayList<Quiz> getQuizesWithStatistics() {
		Connection connection = getConnection();
		ArrayList<Quiz> quizes = new ArrayList<Quiz>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT statistics.true_variants, statistics.time, users.email, users.name, users.surname, tests.name AS tname, tests.id"
					+ " FROM statistics"
					+ " JOIN users ON users.id = statistics.user_id"
					+ " JOIN tests ON statistics.test_id = tests.id");
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        	while(resultSet.next()) {
	        		int quizId = resultSet.getInt(7);
	        		Quiz quiz = null;
	        		quiz = tryGetQuiz(quizes, quizId);
	        		
	        		if (quiz == null) {
	        			quiz = new Quiz();
	        			quiz.setName(resultSet.getString(6));
	        			quiz.setPassedUsers(new ArrayList<Statistics>());
	        			quizes.add(quiz);
	        		}
	        		ArrayList<Statistics> quizStat = quiz.getPassedUsers();
	        		
	        		
	        		Statistics stat = new Statistics();
	        		stat.setTrueVariants(resultSet.getString(1));
	        		User user = new User();
	        		user.setName(resultSet.getString(4));
	        		user.setSurname(resultSet.getString(5));
	        		
	        		stat.setUser(user);
	      
	        		quizStat.add(stat);
	        	}

	        return quizes;
		}catch (Exception e) {
			return null;
		}
	}
	
	public Quiz tryGetQuiz(ArrayList<Quiz> list, int id) {
		for (Quiz quiz : list) {
			if (quiz.getId() == id) {
				return quiz;
			}
		}
		return null;
	}
	
	public void insertQuiz(String name, String desc, String quizBody, String trueAns) {
		Connection connection = getConnection();
		try { 
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = formatter.format(date);
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tests (name, description, test_body, create_date, subject_id, true_answers) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, new String(name.getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setString(2, new String(desc.getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setString(3, new String(quizBody.getBytes("UTF-8"), "UTF-8"));
			preparedStatement.setString(4, currDate);
			preparedStatement.setInt(5, 1);
			preparedStatement.setString(6, trueAns);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
		}
	}
}
