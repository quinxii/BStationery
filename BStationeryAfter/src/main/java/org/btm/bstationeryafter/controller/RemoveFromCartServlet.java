//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Iterator;
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
//import org.btm.bstationeryafter.service.CartItemService;
//import org.btm.bstationeryafter.service.CartItemServiceImpl;
//import org.btm.bstationeryafter.service.CartService;
//import org.btm.bstationeryafter.service.CartServiceImpl;
//import org.btm.bstationeryafter.service.CustomerService;
//import org.btm.bstationeryafter.service.CustomerServiceImpl;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//@WebServlet("/remove-from-cart")
//public class RemoveFromCartServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final Logger logger = LogManager.getLogger(RemoveFromCartServlet.class);
//	private CartItemService cartItemService;
//	private CartService cartService;
//	private CustomerService customerService;
//	
//	@Override
//    public void init() throws ServletException {
//        super.init();
//        cartService = new CartServiceImpl(); 
//        cartItemService = new CartItemServiceImpl();
//        customerService = new CustomerServiceImpl();
//    }
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		HttpSession session = request.getSession();
//		
//		try(PrintWriter out = response.getWriter()){
//			String productId = request.getParameter("productId");
//			String userId = MyUtils.getLoginedUser(session).getEmail();
//        	Customer customer = customerService.getCustomerByUserId(userId);
//			if(productId!=null) {
//				@SuppressWarnings("unchecked")
//				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//				if(cart_list!=null) {
//					for(Cart c:cart_list) {
//						Iterator<CartItem> iterator = c.getCartItem().iterator();
//	                    while (iterator.hasNext()) {
//	                        CartItem cartItem = iterator.next();
//	                        if (cartItem.getProduct().getProductId().equals(productId)) {
//	                        	cartItemService.removeCartItem(cartItem.getCartItemId());
//	                            iterator.remove(); 
//	                            Cart existingCart;
//	                            
//                                existingCart = cartService.findCartByCustomer(customer);
//								existingCart.setTotalQuantity(c.getTotalQuantity()-1);
//								existingCart.setTotalPrice(cartService.getTotalCartPrice(cart_list));
//								if (existingCart.getTotalQuantity() == 0) {
//								    cartService.delete(existingCart.getCartId());
//								} else {
//								    cartService.update(existingCart);
//								}
//
//								cartService.update(existingCart);
//	                            session.setAttribute("cartSize", (Integer) session.getAttribute("cartSize") - 1);
//	                            break;
//	                        }
//	                    }
//					}
//					response.sendRedirect(request.getContextPath()+"/cart");
//				}
//				
//			}
//			else {
//				response.sendRedirect(request.getContextPath()+"/cart");
//			}
//		} catch (IOException e) {
//            logger.error("Failed to remove item from cart.", e);
//            throw e;
//        }	
//	}
//}
