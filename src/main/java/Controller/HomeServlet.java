package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Product;
import Model.User;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 
		 List<Product> allProducts = ProductController.getAllProducts();
		 User loggedInUser = (User) session.getAttribute("loggedInUser");
		 
		 
		 if (loggedInUser != null && req.getParameter("productCost")!=null && req.getParameter("productCost")!="" ) {
			   String productName = req.getParameter("productName"); 
		        String productImage = req.getParameter("productImage");
		        double productCost = Double.parseDouble(req.getParameter("productCost"));
			
	        Product newProduct = new Product(productName, productImage, productCost,loggedInUser);

	        ProductController.addProduct(newProduct);
		 }
		 req.setAttribute("allProducts", allProducts);
		 req.getRequestDispatcher("/WEB-INF/Home.jsp").forward(req, resp);
	    }

}
