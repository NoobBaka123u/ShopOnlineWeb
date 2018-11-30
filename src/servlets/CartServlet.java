package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Item;
import model.Product;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	private final ProductDAO productDAO = new ProductDAO();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String productID = request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");
		
		try {
			Long idproduct = Long.parseLong(productID);
			Product product = productDAO.getProduct(Long.parseLong(productID));
			switch(command) {
				case "plus":
					if(cart.getCartItems().containsKey(idproduct)) {
						cart.plusToCart(idproduct, new Item(product, cart.getCartItems().get(idproduct).getQuantity()));
					} else {
						cart.plusToCart(idproduct, new Item(product, 1));
					}
					break;
				case "remove":
					cart.removeToCart(idproduct);
					break;
					
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/shop/index.jsp");
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("/shop/index.jsp");
	}

}
