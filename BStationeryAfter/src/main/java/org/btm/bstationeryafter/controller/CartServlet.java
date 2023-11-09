package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

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
import org.btm.bstationeryafter.model.CartItem;
import org.btm.bstationeryafter.model.Product;
import org.btm.bstationeryafter.service.CartService;
import org.btm.bstationeryafter.service.CartServiceImpl;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger();
    private CartService cartService;
    
    @Override
    public void init() throws ServletException {
        super.init();
        cartService = new CartServiceImpl(); 
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
        if (cartList != null) {
            for (Cart cart : cartList) {
            	for(CartItem cartItem: cart.getCartItem()) {
            		Product product = cartItem.getProduct();
					cartItem.setProduct(product);
            	}
            }

            BigDecimal total = cartService.getTotalCartPrice(cartList);
            request.setAttribute("total", total);
            logger.info("Total: {}", total);
     
        }
        request.setAttribute("cartList", cartList); 
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/cartView.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
