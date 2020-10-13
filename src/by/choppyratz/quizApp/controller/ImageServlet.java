package by.choppyratz.quizApp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Base64;
/**
 * Servlet implementation class HelloServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ImageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String url = request.getRequestURL().toString();
		String relativeImagePath = url.replaceFirst(".*/image/", "");
		String appPath = request.getServletContext().getRealPath("") + "WEB-INF/img/";
		String absoluteImagePath = appPath + relativeImagePath;
		
		File f = new File(absoluteImagePath);
		if (f.exists()) {
			FileInputStream fileStream = new FileInputStream(absoluteImagePath);
		    byte[] buffer = new byte[fileStream.available()];
		    
		    fileStream.read(buffer, 0, fileStream.available());
		    
		    response.getOutputStream().write(buffer);
		    response.getOutputStream().flush();
		    response.getOutputStream().close();  
		    
		    fileStream.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
