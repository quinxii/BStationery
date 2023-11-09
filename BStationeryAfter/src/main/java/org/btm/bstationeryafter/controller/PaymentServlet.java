//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
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
//import org.btm.bstationeryafter.service.CartService;
//import org.btm.bstationeryafter.service.ProductService;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//import btm.com.core.model.Product;
//import btm.com.core.model.UserProfile;
//
//@WebServlet("/payment")
//public class PaymentServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private static final Logger logger = LogManager.getLogger(PaymentServlet.class);
//    private ProductService productService;
//    private CartService cartService;
//    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//
//        @SuppressWarnings("unchecked")
//        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
//        BigDecimal total = BigDecimal.ZERO;
//
//        UserProfile user = MyUtils.getLoginedUser(session);
//        
//        if (cartList != null && user != null) {
//        	logger.info("Retrieving cart products...");
//            for (Cart cart : cartList) {
//				for(CartItem cartItem:cart.getCartItem()) {
//					String productId = cartItem.getCartItemId();
//					Product product = productService.findProductById(productId);
//					cartItem.setProduct(product);
//				}
//			}
//			
//			total = cartService.getTotalCartPrice(cartList);
//			request.setAttribute("total", total);
//			logger.info("Total: {}", total);
//			
//			request.setAttribute("cartList", cartList);
//        } else {
//            if (user == null) {
//                response.sendRedirect(request.getContextPath() + "/login");
//                return;
//            }
//            response.sendRedirect(request.getContextPath() + "/cart");
//            return;
//        }
//        request.setAttribute("total", total);
//
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/paymentView.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//}
