package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Offer;
import Model.User;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    HttpSession session = req.getSession();
	        User loggedInUser = (User) session.getAttribute("loggedInUser");
	        
	        

	        if (loggedInUser != null) {
	            List<Offer> userOffers = ProductController.getOffersByUser(loggedInUser);
	            req.setAttribute("userOffers", userOffers);
	            req.setAttribute("loggedInUser", loggedInUser);
	            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
	        } else {
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(req, resp);
	        	resp.sendRedirect(req.getContextPath() + "/Login.jsp");
	        }
	    }
                
}
