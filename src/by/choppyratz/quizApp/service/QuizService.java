package by.choppyratz.quizApp.service;
import java.util.ArrayList;
import by.choppyratz.quizApp.bean.Quiz;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.dao.QuizDAO;
import by.choppyratz.quizApp.dao.StatisticsDAO;
import by.choppyratz.quizApp.bean.Statistics;

public class QuizService {
	public static ArrayList<Quiz> getAllQuizes() {
		QuizDAO quizDB = new QuizDAO();
		return quizDB.getAllQuizes();
	}
	
	public static Quiz getQuizById(int id) {
		QuizDAO quizDB = new QuizDAO();
		return quizDB.getQuizById(id);
	}
	
	public static String checkQuizAnswers(int id, String inputAnswers) {
		String result = "";
		Quiz quiz = getQuizById(id);
		String[] answers = quiz.getAnswers().split(";");
		String[] iAnswers = inputAnswers.split(";");
		for (int i = 0; i < answers.length; i++) {
			if (answers[i].equals(iAnswers[i])) {
				result += "1";
			}else {
				result += "0";
			}
			
			if (i != answers.length - 1){
				result += ';';
			}
		}
		return result;
	}
	
	public static void writeStatistics(int testId, int userId, String trueVariants) {
		StatisticsDAO statDB = new StatisticsDAO();
		statDB.insertStatistics(testId, userId, trueVariants);
	}
	
	public static Statistics isUserPassThisQuiz(Quiz test, User user) {
		StatisticsDAO statDB = new StatisticsDAO();
		Statistics stat = statDB.getStatisticsByTestAndUserId(test, user);
		return stat;
	}
	
	
	public static ArrayList<Quiz> getQuizesWidthStatistics() {
		QuizDAO quizDB = new QuizDAO();
		ArrayList<Quiz> list = quizDB.getQuizesWithStatistics();
		return list;
	}
	
	public static void insertQuiz(String name, String desc, String quizBody, String trueAns) {
		QuizDAO quizDB = new QuizDAO();
		quizDB.insertQuiz(name, desc, quizBody, trueAns);
	}
	
}
