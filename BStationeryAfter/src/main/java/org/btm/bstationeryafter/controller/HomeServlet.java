package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.time.LocalDateTime;
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

@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LogManager.getLogger(HomeServlet.class);
   private ProductService productService;
	@Override
    public void init() throws ServletException {
       super.init();
       productService = new ProductServiceImpl(); 
    }

   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
	   	logger.info("HomeServlet - Accessed home page at: {}", LocalDateTime.now());

	   	HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		List<Product> list = null;
		list = productService.findAllProducts();

		if(cart_list!=null) {
			int cartSize = 0;
		    for (Cart cart : cart_list) {
		        cartSize += cart.getCartItem().size();
		    }
		    session.setAttribute("cartSize", cartSize);
		    request.setAttribute("cart_list", cart_list);
		}
		
		request.setAttribute("productList", list);

       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/homeView.jsp");
       
       dispatcher.forward(request, response);
       
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }

}
