//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
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
//import org.btm.bstationeryafter.model.Product;
//import org.btm.bstationeryafter.service.CartItemService;
//import org.btm.bstationeryafter.service.CartItemServiceImpl;
//import org.btm.bstationeryafter.service.CartService;
//import org.btm.bstationeryafter.service.CartServiceImpl;
//import org.btm.bstationeryafter.service.CustomerService;
//import org.btm.bstationeryafter.service.CustomerServiceImpl;
//import org.btm.bstationeryafter.service.ProductService;
//import org.btm.bstationeryafter.service.ProductServiceImpl;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//import btm.com.core.model.UserProfile;
//
//@WebServlet("/add-to-cart")
//public class AddToCartServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static final Logger logger = LogManager.getLogger(AddToCartServlet.class);
//	
//	private CartItemService cartItemService;
//	private CartService cartService;
//	private ProductService productService;
//	private CustomerService customerService;
//	
//	@Override
//    public void init() throws ServletException {
//        super.init();
//        productService = new ProductServiceImpl(); 
//        cartService = new CartServiceImpl(); 
//        cartItemService = new CartItemServiceImpl();
//        customerService = new CustomerServiceImpl();
//    }
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String referer = request.getHeader("referer");
//		try(PrintWriter out = response.getWriter()){
//			String action = request.getParameter("action");
//			String productId = request.getParameter("productId");
//			
//			Product product =  productService.getProductById(productId);
//			logger.info("Adding item to cart. Product ID: {}", productId);
//
//			HttpSession session = request.getSession();
//			UserProfile loginedUser = MyUtils.getLoginedUser(session);
//            
//            if (loginedUser == null) {
//    			// Redirect to login page.
//    			response.sendRedirect(request.getContextPath() + "/login");
//    			logger.warn("Unauthorized access to user information page");
//    			return;
//    		}
//            else {
//            	String userId = MyUtils.getLoginedUser(session).getEmail();
//            	Customer customer = customerService.getCustomerByUserId(userId);
//            	@SuppressWarnings("unchecked")
//    			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
//    			if (cartList == null) {
//    			    cartList = new ArrayList<>();
//    			    session.setAttribute("cart-list", cartList);
//    			}
//
//    			boolean exist = false;
//    			for (Cart c : cartList) {
//    			    Iterator<CartItem> iterator = c.getCartItem().iterator();
//    			    while (iterator.hasNext()) {
//    			    	CartItem cartItem = iterator.next();
//    			        if (cartItem.getProduct().getProductId().equals(productId)) {
//    			            exist = true;
//    			            int updatedQuantity = c.getTotalQuantity() + 1;
//    			            c.setTotalQuantity(updatedQuantity);
//    			            break;
//    			        }
//    			    }
//    			}
//
//    			if (!exist) {
//    			    Cart cart = new Cart();
//    			    CartItem cartProduct = new CartItem();
//    			    cartProduct.setQuantity(1);
//    			    cartProduct.setPrice(product.getProductPrice());
//    			    cartProduct.setProduct(product);
//    			    cartProduct.setCart(cart);
//    			    cart.insertToCart(cartProduct);
//
//    			    cart.setTotalQuantity(1);
//    			    cartList.add(cart);
//    			}
//
//    			BigDecimal total = cartService.getTotalCartPrice(cartList);
//
//    			Cart existingCart;
//    			existingCart = cartService.findCartByCustomer(customer);
//    			if (existingCart != null) {
//    			    existingCart.setTotalQuantity(cartList.size());
//    			    existingCart.setTotalPrice(total);
//    			    cartService.update(existingCart);
//    			} else {
//    			    Cart cart = new Cart();
//    			    String cartId = userId+"Cart";
//    			    cart.setCartId(cartId);
//    			    cart.setCustomer(customer);
//    			    cart.setTotalPrice(total);
//    			    cart.setTotalQuantity(cartList.size());
//    			    cartService.insert(cart,customer);
//    			}
//    			
//    			for (Cart cart : cartList) {
//    				for(CartItem cartItem: cart.getCartItem()) {
//    					Cart c;
//    					c = cartService.findCartByCustomer(customer);
//    					CartItem cartPro = new CartItem();
//    					cartPro.setCart(c); 
//    					Product pro = productService.getProductById(cartItem.getProduct().getProductId());
//    					cartPro.setProduct(pro);
//    					cartPro.setQuantity(cartItem.getQuantity());
//    					cartPro.setPrice(pro.getProductPrice());
//    					cartItemService.insert(cartPro, c);
//    				}       
//    			}
//                
//    			if(action != null && action.equals("buy")) {
//    	            response.sendRedirect(request.getContextPath() + "/cart");
//    	            logger.info("Redirecting to cart page for checkout process.");
//    	        } 
//    			else {
//    	        	if (referer != null && !referer.isEmpty()) {
//    	        	    response.sendRedirect(referer);
//    	        	    logger.info("Redirecting back to the referring page: {}", referer);
//    	        	} 
//    	        	else {
//    	        	    response.sendRedirect(request.getContextPath() + "/home");
//    	        	    logger.info("Redirecting to home page: /home");
//    	        	}
//    	        }
//            }
//		}catch (Exception e) {
//            logger.error("An error occurred while adding item to cart: {}", e.getMessage());
//            e.printStackTrace();
//        }
//	}
//
//}
