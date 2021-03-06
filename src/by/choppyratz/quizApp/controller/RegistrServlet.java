package by.choppyratz.quizApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.choppyratz.quizApp.service.AuthService;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
public class RegistrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		if (AuthService.checkAuth(request) == null) {
			request.getRequestDispatcher("WEB-INF/jsp/registr.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		if (AuthService.RegistrUser(email, name, surname, password, request)) {
			response.sendRedirect(request.getContextPath());
		}else {
			doGet(request, response);
		}
	}

}
