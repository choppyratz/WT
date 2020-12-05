package by.choppyratz.quizApp.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 2041275512219239990L;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String rememberToken;
	private int roleId;
	private int id;
	
	public User setRememberToken(String _rememberToken) {
		rememberToken = _rememberToken;
		return this;
	}
	
	public String getRememberToken() {
		return rememberToken;
	}
	
	public User setPassword(String _password) {
		password = _password;
		return this;
	}
	
	public String getPassword() {
		return password;
	}

	public User setEmail(String _email) {
		email = _email;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public User setName(String _name) {
		name = _name;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public User setSurname(String _surname) {
		surname = _surname;
		return this;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public User setRoleId(int id) {
		roleId = id;
		return this;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
