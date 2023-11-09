//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
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
//import org.btm.bstationeryafter.model.Customer;
//import org.btm.bstationeryafter.model.CustomerOrder;
//import org.btm.bstationeryafter.model.Product;
//import org.btm.bstationeryafter.service.CustomerOrderService;
//import org.btm.bstationeryafter.service.ProductService;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//import btm.com.core.model.UserProfile;
//
//@WebServlet("/user-orders")
//public class UserOrdersServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final Logger logger = LogManager.getLogger(UserOrdersServlet.class);
//	private ProductService productService;
//	private CustomerOrderService customerOrderService;
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		String productId = request.getParameter("id");
//		@SuppressWarnings("unchecked")
//		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//		Product product = null;
//		UserProfile loginedUser = MyUtils.getLoginedUser(session);
//		Customer loginedCustomer = (Customer)MyUtils.getLoginedUser(session);
//		logger.info("Logined Customer is ",loginedCustomer);
//		if(loginedUser != null) {
//			request.setAttribute("loginedUser", loginedUser);
//			List<CustomerOrder> orders = customerOrderService.getCustomerOrder(loginedCustomer);
//			
//			product = productService.getProductById(productId);
//			request.setAttribute("orders", orders);
//		}
//		else {
//            if (loginedUser == null) {
//                response.sendRedirect(request.getContextPath() + "/login");
//                return;
//            }
//        }
//		if(cart_list!=null) {
//			request.setAttribute("cart_list", cart_list);
//		}
//		request.setAttribute("product", product);
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/userOrdersView.jsp");
//        dispatcher.forward(request, response);
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
