package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageBody;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageHeader;
import org.btm.bstationeryafter.common.model.UserProfileMessage;
import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.service.UserService;
import org.btm.bstationeryafter.service.UserServiceImpl;
import org.btm.bstationeryafter.utils.MyUtils;
import org.apache.logging.log4j.LogManager;

@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UserInfoServlet.class);
	private UserService userService;

	@Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl(); // Create an instance of UserServiceImpl
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		
		// Check User Login
		UserProfileMessage loginedUser = MyUtils.getLoginedUser(session);
		
		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			logger.warn("Unauthorized access to user information page");
			return;
		}
		
		//Check cart list
		if(cart_list!=null) {
			request.setAttribute("cart_list",cart_list);
		}

		try {
			InetAddress IP = InetAddress.getLocalHost();
			UserProfileMessage userProfile = new UserProfileMessage();
			List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>();
			userProfile.setEmail(loginedUser.getEmail());
			userProfiles.add(userProfile);
			
			IntegrationMessage msgRequest = new IntegrationMessage();
			
			IntegrationMessageHeader header = new IntegrationMessageHeader();
			IntegrationMessageBody body = new IntegrationMessageBody();
			
			header.setAddressIp(IP.toString());
			body.setUserProfileMessage(userProfiles);
			
			msgRequest.setHeader(header);
			msgRequest.setBody(body);
			
			UserProfileMessage user = null;
			IntegrationMessage msgResponse = userService.getUserById(msgRequest);
			if (msgResponse.getHeader().getErrorCode().equals("USR003")) {
				user = msgResponse.getBody().getUserProfileMessage().get(0);
			}else {
				user = null;
			}
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/userInfoView.jsp");
			dispatcher.forward(request, response);
			
			logger.info("User information displayed successfully");
		}catch (Exception e) {
			e.printStackTrace();	
			logger.error("Error occurred while retrieving user information", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");

		String originalUserEmail = request.getParameter("originalUserEmail");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserProfileMessage user = null;
		String errorString = null;
		
		InetAddress IP = InetAddress.getLocalHost();
		UserProfileMessage userProfileMsg = new UserProfileMessage();
		List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>();
		userProfileMsg.setEmail(originalUserEmail);
		userProfileMsg.setFullName(name);
		userProfileMsg.setPhone(phone);
		userProfileMsg.setDob(date);
		
		userProfiles.add(userProfileMsg);
		IntegrationMessage msgRequest = new IntegrationMessage();
		
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		
		header.setAddressIp(IP.toString());
		body.setUserProfileMessage(userProfiles);
		
		msgRequest.setHeader(header);
		msgRequest.setBody(body);
		
		IntegrationMessage msgResponse = userService.updateInfo(msgRequest);
		if (msgResponse.getHeader().getErrorCode().equals("USR003")) {
			user = msgResponse.getBody().getUserProfileMessage().get(0);
		}else {
			user = null;
		}
		
		logger.info("User information updated successfully", user.getEmail());
		
		// Store information to request attribute, before forward to view.
		request.setAttribute("errorString", errorString);

		// Redirect to the doGet() method to display the updated information
		response.sendRedirect(request.getContextPath() + "/userInfo");
	}
}
