package by.choppyratz.quizApp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.dao.UserDAO;

import java.security.MessageDigest;
import java.util.Random;

public class AuthService {
	public static User checkAuth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("authToken") == null) {
			return null;
		}else {
			UserDAO userDB = new UserDAO();
			return userDB.getUser(session.getAttribute("authToken").toString());
		}
	}
	
	public static boolean RegistrUser(String email, String name, String surname, String password, HttpServletRequest request) {
		try {
			User user = new User();
			UserDAO userDB = new UserDAO();
			
			user = user.setEmail(email);
			user = user.setName(name);
			user = user.setPassword(password);
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(user.getPassword().getBytes("UTF-8"));
			String encryptedString = new String(messageDigest.digest());
			user = user.setPassword(encryptedString);
			user = user.setRoleId(1);
			user = user.setSurname(surname);
			
			user = userDB.insertUser(user);
			if (AuthUser(user.getEmail(), password, request)) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public static boolean AuthUser(String email, String password, HttpServletRequest request) {
		try {
			UserDAO userDB = new UserDAO();
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes("UTF-8"));
			String encryptedString = new String(messageDigest.digest());
			User tempUser = userDB.getUser(email, encryptedString);
			if (tempUser != null) {
				Random rd = new Random(System.currentTimeMillis());
				byte[] arr = new byte[30];
			    rd.nextBytes(arr);

				tempUser.setRememberToken(arr.toString());
				userDB.updateUser(tempUser);
				request.getSession().setAttribute("authToken", arr.toString());
				return true;
			}
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	
	public static void LogoutUser(HttpServletRequest request) {
		request.getSession().invalidate();
		//request.getSession().setAttribute("authToken", "null");
	}
}
