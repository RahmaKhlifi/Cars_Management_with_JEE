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
import Model.Product;
import Model.User;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    HttpSession session = req.getSession();
		    String productName = req.getParameter("productName");
		    User loggedInUser = (User) session.getAttribute("loggedInUser");
		    
	        Product product = ProductController.getProductByName(productName);
	        
	        if (product != null&&loggedInUser != null) {
	        	if(req.getParameter("bidAmount")!=null&&req.getParameter("bidAmount")!="") {
	 	        	Double bidAmount  = Double.parseDouble(req.getParameter("bidAmount"));
	 	        	ProductController.placeBid(loggedInUser,product,bidAmount);
	 	        	//req.getRequestDispatcher("/WEB-INF/productDetails.jsp").forward(req, resp);
	        	}
	                List<Offer> productOffers = ProductController.getOffersForProduct(product);
	                req.setAttribute("product", product);
	                req.setAttribute("productOffers", productOffers);
	                req.getRequestDispatcher("/WEB-INF/productDetails.jsp").forward(req, resp);
	        } else {
	        	resp.sendRedirect(req.getContextPath() + "/home");
	        }
	    }
              
}
