package org.btm.bstationeryafter.controller;

import java.io.IOException;
import java.net.InetAddress;
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
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageBody;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageHeader;
import org.btm.bstationeryafter.common.model.UserProfileMessage;
import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.service.UserService;
import org.btm.bstationeryafter.service.UserServiceImpl;
import org.btm.bstationeryafter.utils.MyUtils;
import org.btm.bstationeryafter.utils.PasswordUtils;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ChangePasswordServlet.class);
	private UserService userService;

	@Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl(); // Create an instance of UserServiceImpl
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		// Check User has logged on
		UserProfileMessage loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
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
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/view/changePasswordView.jsp");
	        dispatcher.forward(request, response);
		}catch (Exception e) {
			logger.error("Error occurred while retrieving user information: {}", e.getMessage());
			e.printStackTrace();		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newPassword = request.getParameter("newPassword");
		String originalEmail = request.getParameter("originalEmail");

		String hashedPassword = PasswordUtils.hashPassword(newPassword);
		
		InetAddress IP = InetAddress.getLocalHost();
		UserProfileMessage userProfileMsg = new UserProfileMessage();
		List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>();
		userProfileMsg.setEmail(originalEmail);
		userProfileMsg.setUserPwd(hashedPassword);
		
		userProfiles.add(userProfileMsg);
		IntegrationMessage msgRequest = new IntegrationMessage();
		
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		
		header.setAddressIp(IP.toString());
		body.setUserProfileMessage(userProfiles);
		
		msgRequest.setHeader(header);
		msgRequest.setBody(body);
		
		userService.updatePassword(msgRequest);

		logger.info("Password updated for user: {}", originalEmail);
		request.setAttribute("hashedPassword", hashedPassword);
 
		response.sendRedirect(request.getContextPath() + "/login");
	}
}
