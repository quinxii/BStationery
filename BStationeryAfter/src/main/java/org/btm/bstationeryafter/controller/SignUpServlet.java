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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageBody;
import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessageHeader;
import org.btm.bstationeryafter.common.model.UserProfileMessage;
import org.btm.bstationeryafter.service.UserService;
import org.btm.bstationeryafter.service.UserServiceImpl;
import org.btm.bstationeryafter.utils.PasswordUtils;

@WebServlet(urlPatterns= {"/signup"})
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(SignUpServlet.class);
	private UserService userService;

	@Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl(); 
    }
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/signupView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Sign up process initiated.");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String userPwd = request.getParameter("userPwd");
		String phoneNumber = request.getParameter("phoneNumber");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		try {
			date = df.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserProfileMessage user = null;
		String errorString = null;

		String hashedPassword = PasswordUtils.hashPassword(userPwd);
		
		InetAddress IP = InetAddress.getLocalHost();
		UserProfileMessage userProfileMsg = new UserProfileMessage();
		List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>();
		userProfileMsg.setEmail(email);
		userProfileMsg.setFullName(name);
		userProfileMsg.setUserPwd(hashedPassword);
		userProfileMsg.setPhone(phoneNumber);
		userProfileMsg.setGender("male".equals(gender) ? true : false);
		userProfileMsg.setDob(date);
		
		userProfiles.add(userProfileMsg);
		IntegrationMessage msgRequest = new IntegrationMessage();
		
		IntegrationMessageHeader header = new IntegrationMessageHeader();
		IntegrationMessageBody body = new IntegrationMessageBody();
		
		header.setAddressIp(IP.toString());
		body.setUserProfileMessage(userProfiles);
		
		msgRequest.setHeader(header);
		msgRequest.setBody(body);
		
		IntegrationMessage msgResponse = userService.register(msgRequest);
		if (msgResponse.getHeader().getErrorCode().equals("USR004")) {
			user = msgResponse.getBody().getUserProfileMessage().get(0);
		}else {
			user = null;
		}
		if(user==null) {
			errorString = "Email "+email+" already exists!";
			request.setAttribute("errorString", errorString);
		}else {
			logger.info("Password hashed successfully for user: " + user.getEmail());			
		}
		
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/signupView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/login");
			logger.info("Sign up process completed.");
		}

		request.setAttribute("user", user);

	}
}
