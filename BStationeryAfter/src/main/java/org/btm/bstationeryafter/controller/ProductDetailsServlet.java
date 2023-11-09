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

import btm.com.core.model.Category;
import btm.com.core.model.Product;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(ProductDetailsServlet.class);
    private ProductService productService;
    
    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the product ID from the request parameter
    	HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

        String upc = request.getParameter("upc");
        String errorString = null;
        Product product = null;
        List<Product> list = null;
        
		list = productService.findAllProducts();
		product = productService.findProductById(upc);
		logger.info("Product details retrieved successfully. UPC: {}", upc);
		
        if(cart_list!=null) {
        	int cartSize = 0;
		    for (Cart cart : cart_list) {
		        cartSize += cart.getCartItem().size();
		    }
		    session.setAttribute("cartSize", cartSize);
			request.setAttribute("cart_list",cart_list);
		}
        // Set the product and error information as request attributes
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
        request.setAttribute("productList", list);
        
        Category currentProductCategory = product.getCategoryId();
		List<Product> similarProducts = productService.getSimilarProductsByCategory(currentProductCategory, upc);

	    // Add similar products to the request attributes
	    request.setAttribute("similarProducts", similarProducts);


        // Forward the request to the product details view (JSP)
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/view/productDetailsView.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
}

