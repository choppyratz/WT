package by.choppyratz.quizApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.choppyratz.quizApp.service.AuthService;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.dao.*;

/**
 * Servlet implementation class HelloServlet
 */
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogOutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		if (AuthService.checkAuth(request) == null) {
			AuthService.LogoutUser(request);
		}
		response.sendRedirect("/quizApp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
