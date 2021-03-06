package by.choppyratz.quizApp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.NumberFormatException;
import by.choppyratz.quizApp.bean.User;
import by.choppyratz.quizApp.bean.Quiz;
import by.choppyratz.quizApp.bean.Statistics;
import by.choppyratz.quizApp.service.AuthService;
import by.choppyratz.quizApp.service.QuizService;

/**
 * Servlet implementation class HelloServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user = AuthService.checkAuth(request);
		ServletContext selvletContext = getServletContext();
		if (user != null) {
	        selvletContext.setAttribute("user", user);
		}else {
			response.sendRedirect("/quizApp");
			return;
		}
		
		String paramId = request.getParameter("id");
		try {
			int id = Integer.parseInt(paramId);
			Quiz quiz = QuizService.getQuizById(id);
			if (quiz != null) {
				Statistics stat = QuizService.isUserPassThisQuiz(quiz, user);
				if (stat != null) {
					selvletContext.setAttribute("isPassed", true);
					selvletContext.setAttribute("stat", stat);
				}else {
					selvletContext.setAttribute("quiz", quiz);
					selvletContext.setAttribute("isPassed", false);
				}
				request.getRequestDispatcher("WEB-INF/jsp/testPage.jsp").forward(request, response);
			}else {
				response.sendRedirect("/quizApp");
			}	
		}catch (NumberFormatException e) {
			response.sendRedirect("/quizApp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		try {
			int id = Integer.parseInt(paramId);
			User user = AuthService.checkAuth(request);
			String result = QuizService.checkQuizAnswers(id, request.getParameter("answers"));
			QuizService.writeStatistics(id, user.getId(), result);
			response.getWriter().println(result);
		}catch (NumberFormatException e) {
			
		}
	}

}
