package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.User;
import metier.session.IUser;
import metier.session.UserImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IUser userdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
    	      response.setContentType("text/html");
    	      PrintWriter out = response.getWriter();
    	      HttpSession session = request.getSession(false);
    	      // session.setAttribute("user", null);
    	      session.removeAttribute("user");
    	      session.getMaxInactiveInterval();
    	      request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
		
			User us = userdao.getLogin(email, password);
			
			if (us != null) {
			//response.sendRedirect("Client");
			HttpSession session = request.getSession(true);
			
			session.setAttribute("user", email);
	        session.setMaxInactiveInterval(200); // 30 seconds
	        //response.sendRedirect("Client");
	        response.sendRedirect("Village");
	         
			} else {
			request.setAttribute("error", "Informations incorrectes");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
