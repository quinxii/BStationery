package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.model.CartItem;
import org.btm.bstationeryafter.service.CartItemService;
import org.btm.bstationeryafter.service.CartService;

@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(QuantityIncDecServlet.class);
	private CartItemService cartItemservice;
	private CartService cartService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try(PrintWriter out = response.getWriter()){
			String action = request.getParameter("action");
			String id = request.getParameter("id");
			@SuppressWarnings("unchecked")
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			if(action!=null && id!=null) {
				if(action.equals("inc")) {
					for(Cart c:cart_list) {	
						for(CartItem cartItem:c.getCartItem()) {
							if(cartItem.getCartItemId().equals(id)) {
								int quantity = c.getTotalQuantity();
								quantity++;
								c.setTotalQuantity(quantity);
								cartItemservice.updateItemQuantity(cartItem.getProduct().getProductId(), quantity);
								logger.info("Quantity incremented for item. ID: {}", id);
								response.sendRedirect(request.getContextPath()+"/cart");
							}							
						}
					}
				}
				
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						for(CartItem cartItem:c.getCartItem()) {
							if(cartItem.getCartItemId().equals(id) && c.getTotalQuantity()>1) {
								int quantity = c.getTotalQuantity();
								quantity--;
								c.setTotalQuantity(quantity);
								cartItemservice.updateItemQuantity(cartItem.getProduct().getProductId(), quantity);
								cartService.update(c);
								logger.info("Quantity decremented for item. ID: {}", id);
								break;
							}							
						}
					}	
					response.sendRedirect(request.getContextPath()+"/cart");
				}
			}
			else {
				response.sendRedirect(request.getContextPath()+"/cart");
			}
		}	
	}
}
