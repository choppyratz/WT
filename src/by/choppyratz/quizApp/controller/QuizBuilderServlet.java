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
public class QuizBuilderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QuizBuilderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user = AuthService.checkAuth(request);
		ServletContext selvletContext = getServletContext();
		if (user != null && user.getRoleId() == 2) {
	        selvletContext.setAttribute("user", user);
	        request.getRequestDispatcher("WEB-INF/jsp/quizBuilder.jsp").forward(request, response);
		}else {
			response.sendRedirect("/quizApp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String quizName = request.getParameter("name");
		String quizDesc = request.getParameter("description");
		String quizBody = request.getParameter("quizBody");
		String trueAns = request.getParameter("trueAns");
		QuizService.insertQuiz(quizName, quizDesc, quizBody, trueAns);
		response.getWriter().println(quizBody + "answer");
	}

}
