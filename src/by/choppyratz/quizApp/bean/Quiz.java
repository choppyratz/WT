package by.choppyratz.quizApp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import by.choppyratz.quizApp.bean.Statistics;

public class Quiz implements Serializable {
	private static final long serialVersionUID = 2041275512219239990L;
	private int id;
	private String name;
	private String description;
	private String createDate;
	private int subject;
	private String testBody;
	private String answers;
	private ArrayList<Statistics> passedUsers;
	
	public Quiz() {
	
	}
	
	public Quiz(int _id, String _name, String _desc, String date, int _subject) {
		id = _id;
		name = _name;
		description = _desc;
		subject = _subject;
	}
	
	public int getId() {
        return id;
    }
	
	public void setId(int id) {
        this.id = id;
    }
 
	
    public String getName() {
        return name;
    }
 
    public void setName(String _name) {
        this.name = _name;
    }
    
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String _description) {
        this.description = _description;
    }
    
    public String getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(String _createDate) {
        this.createDate = _createDate;
    }
    
    public int getSubject() {
        return subject;
    }
 
    public void setSubject(int id) {
        this.subject = id;
    }
    
    public String getTestBody() {
        return testBody;
    }
 
    public void setTestBody(String _testBody) {
        this.testBody = _testBody;
    }
    
    public String getAnswers() {
        return answers;
    }
 
    public void setAnswers(String Answers) {
        this.answers = Answers;
    }
    
    public ArrayList<Statistics> getPassedUsers() {
        return passedUsers;
    }
 
    public void setPassedUsers(ArrayList<Statistics> users) {
        this.passedUsers = users;
    }
}
