package by.choppyratz.quizApp.bean;

import java.io.Serializable;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.bean.Quiz;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 2041275512219239990L;
	private int testId;
	private int userId;
	private String trueVariants;
	private User user;
	private Quiz test;

	public Statistics() {
		
	}
	
	public int getTestId() {
        return testId;
    }
 
    public void setTtestId(int testId) {
        this.testId = testId;
    }
    
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getTrueVariants() {
        return trueVariants;
    }
 
    public void setTrueVariants(String trueVariants) {
        this.trueVariants = trueVariants;
    }
	
    public Quiz getQuiz() {
        return test;
    }
 
    public void setQuiz(Quiz test) {
        this.test = test;
    }
    
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
	
}
