package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.service.ProductService;
import org.btm.bstationeryafter.service.ProductServiceImpl;

import btm.com.core.model.Product;

@WebServlet(urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ProductListServlet.class);
	private ProductService productService;
	
	@Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductServiceImpl(); 
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		String errorString = null;
		List<Product> list = null;
		list = productService.findAllProducts();
		String sortParam = request.getParameter("sort");

		if (sortParam != null && sortParam.equals("az")) {
		    // Sort the list in ascending order (A -> Z) based on the product name
		    Collections.sort(list, new Comparator<Product>() {
		    	public int compare(Product p1, Product p2) {
		            return p1.getName().compareTo(p2.getName());
		        }
		    });
		}else if (sortParam != null && sortParam.equals("za")) {
		    // Sort the list in descending order (Z -> A) based on the product name
		    Collections.sort(list, new Comparator<Product>() {
		        public int compare(Product p1, Product p2) {
		            return p2.getName().compareTo(p1.getName());
		        }
		    });
		} else if (sortParam != null && sortParam.equals("price_inc")) {
		    // Sort the list in ascending order based on the product price
		    Collections.sort(list, Comparator.comparing(Product::getPrice));
		} else if (sortParam != null && sortParam.equals("price_dec")) {
		    // Sort the list in descending order based on the product price
		    Collections.sort(list, Comparator.comparing(Product::getPrice, Comparator.reverseOrder()));
		} else if (sortParam != null && sortParam.equals("new_arrival")) {
		    // Sort the list in descending order based on the product's creation date
		    Collections.sort(list, Comparator.comparing(Product::getCreatedAt, Comparator.reverseOrder()));
		}
		logger.info("Product list retrieved successfully");
		if(cart_list!=null) {
			int cartSize = 0;
		    for (Cart cart : cart_list) {
		        cartSize += cart.getCartItem().size();
		    }
		    session.setAttribute("cartSize", cartSize);
			request.setAttribute("cart_list",cart_list);
		}
		// Store info in request attribute, before forward to view
		request.setAttribute("errorString", errorString);
		request.setAttribute("productList", list);
		
		// Forward to /WEB-INF/view/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/productListView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
