package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.service.CustomerOrderService;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(CancelOrderServlet.class);
	private CustomerOrderService customerOrderService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try (PrintWriter out = response.getWriter()){
			
			if(id!=null) {
				customerOrderService.cancelCustomerOrder(Integer.parseInt(id));
			}
			response.sendRedirect(request.getContextPath()+"/user-orders");
		}catch (NumberFormatException e) {
            logger.error("Invalid order ID format: {}", e.getMessage());
            e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
