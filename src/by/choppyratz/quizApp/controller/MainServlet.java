package by.choppyratz.quizApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.choppyratz.quizApp.service.AuthService;
import javax.servlet.ServletContext;
import by.choppyratz.quizApp.bean.User;
import java.util.ArrayList;
import by.choppyratz.quizApp.bean.Quiz;
import by.choppyratz.quizApp.service.QuizService;
/**
 * Servlet implementation class HelloServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		ServletContext selvletContext = getServletContext();
		User user = AuthService.checkAuth(request);
		if (user != null) {
	        selvletContext.setAttribute("user", user);
		}
		ArrayList<Quiz> list = QuizService.getAllQuizes();
		selvletContext.setAttribute("quizes", list);
		request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
