package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SearchServlet.class);
	private ProductService productService;
	
	@Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductServiceImpl(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String search = request.getParameter("search");
		
	    logger.info("Performing search for: {}", search);
	    
		List<Product>productList = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		productList = productService.searchProduct(search);
		if (productList != null) {
			logger.info("Search returned {} products", productList.size());
	        request.setAttribute("productList", productList);
	        if(cart_list!=null) {
				request.setAttribute("cart_list",cart_list);
			}
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/searchView.jsp");
            dispatcher.forward(request, response);
	    }
		else {
			logger.warn("No products found for search: {}", search);
            request.setAttribute("searchError", "No products found.");
        }  
	}

}
