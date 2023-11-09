//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.btm.bstationeryafter.model.Cart;
//import org.btm.bstationeryafter.model.CartItem;
//import org.btm.bstationeryafter.model.Customer;
//import org.btm.bstationeryafter.model.CustomerOrder;
//import org.btm.bstationeryafter.model.UserProfile;
//import org.btm.bstationeryafter.service.CustomerOrderService;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//@WebServlet("/checkout")
//public class CheckoutServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final Logger logger = LogManager.getLogger(CheckoutServlet.class);
//	private CustomerOrderService customerOrderService;
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		try(PrintWriter out = response.getWriter()){
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date dateTime = new Date();
//			
//			@SuppressWarnings("unchecked")
//			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//			UserProfile loginedUser = MyUtils.getLoginedUser(session);
//			Customer loginedCustomer = (Customer) MyUtils.getLoginedUser(session);
//			
//			if (cart_list!=null && loginedUser != null) {				
//				for(Cart c:cart_list) {
//			        for(CartItem cartItem:c.getCartItem()) {
//			        	String productId = cartItem.getCartItemId();
//			        	CustomerOrder order = new CustomerOrder();
//			        	order.setCart(c);
//			        	order.setCustomer(loginedCustomer);
//			        	order.setCustomerOrderDate(formatter.format(dateTime));
//			        	order.setPaymentMethod(null);
//			        	order.setShippingAddress(null);
//			        	order.setStoreAddress(null);
//			        	
//			        	boolean result = customerOrderService.addCustomerOrder(order);
//			        	
//			        	if(!result) {
//			        		logger.error("Failed to insert order for product with ID: {}", productId);
//			        		break;
//			        	}
//			        }
//	 			}
//				cart_list.clear();
//				response.sendRedirect(request.getContextPath()+"/user-orders");
//				logger.info("Checkout processs completed successfully.");
//			}else {
//				if(loginedUser == null) response.sendRedirect(request.getContextPath() + "/login");
//				response.sendRedirect(request.getContextPath()+"/cart");
//			}
//		}catch(Exception e) {
//			logger.error("Error occurred during checkout process: {}", e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
