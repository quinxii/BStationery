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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageBody;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageHeader;
import org.btm.bstationeryafter.common.model.UserProfileMessage;
import org.btm.bstationeryafter.service.UserService;
import org.btm.bstationeryafter.service.UserServiceImpl;

@WebServlet(urlPatterns = { "/user-deactivation" })
public class UserDeactivation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UserDeactivation.class);
	private UserService userService;

	@Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl(); // Create an instance of UserServiceImpl
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String enabled = request.getParameter("enabled");
		
		InetAddress IP = InetAddress.getLocalHost();
		UserProfileMessage userProfileMsg = new UserProfileMessage();
		List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>();
		userProfileMsg.setEmail(email);
		userProfileMsg.setEnabled("true".equals(enabled) ? true : false);
		
		userProfiles.add(userProfileMsg);
		IntegrationMessage msgRequest = new IntegrationMessage();
		
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		
		header.setAddressIp(IP.toString());
		body.setUserProfileMessage(userProfiles);
		
		msgRequest.setHeader(header);
		msgRequest.setBody(body);
		
		userService.deactiveUser(msgRequest);

		logger.info("User deactivated successfully");

		// Redirect to the doGet() method to display the updated information
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
