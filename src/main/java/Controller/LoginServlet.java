package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username = req.getParameter("username");
	        String password = req.getParameter("password");

	        if (UserController.authenticateUser(username, password)) {
	            HttpSession session = req.getSession();
	            session.setAttribute("loggedInUser", UserController.getUserByUsername(username));
	            resp.sendRedirect(req.getContextPath() + "/home");
	        } else {
	        	
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(req, resp);
	        	 resp.sendRedirect(req.getContextPath() + "/WEB-INF/Login.jsp");
	           
	        }
	}
   
}

