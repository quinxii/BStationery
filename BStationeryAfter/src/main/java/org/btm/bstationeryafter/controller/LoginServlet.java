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
import org.btm.bstationeryafter.service.UserService;
import org.btm.bstationeryafter.service.UserServiceImpl;
import org.btm.bstationeryafter.utils.MyUtils;
import org.btm.bstationeryafter.utils.PasswordUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(LoginServlet.class);
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
				.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String userPwd = request.getParameter("userPwd");
		
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		UserProfileMessage userProfile = new UserProfileMessage();
		List<UserProfileMessage> userProfiles = new ArrayList<UserProfileMessage>(); 
		boolean hasError = false;
		String errorString = null;
		
		InetAddress IP = InetAddress.getLocalHost();
		
		UserProfileMessage user = null;
		logger.warn("Failed login attempt for user {}", email);
		if (email == null || userPwd == null || email.length() == 0 || userPwd.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			userProfile.setEmail(email);
			userProfile.setUserPwd(PasswordUtils.hashPassword(userPwd));
			userProfiles.add(userProfile);
			
			IntegrationMessage msgRequest = new IntegrationMessage();
			
			IntegrationMessageHeader header = new IntegrationMessageHeader();
			IntegrationMessageBody body = new IntegrationMessageBody();
			
			header.setAddressIp(IP.toString());
			body.setUserProfileMessage(userProfiles);
			
			msgRequest.setHeader(header);
			msgRequest.setBody(body);
			
			IntegrationMessage msgResponse = userService.login(msgRequest);
			if (msgResponse.getHeader().getErrorCode().equals("USR003")) {
				user = msgResponse.getBody().getUserProfileMessage().get(0);
			}else {
				user = null;
			}
			if (user==null) {
				hasError = true;
				errorString = msgResponse.getHeader().getErrorDetail();
			} else {
				if (!PasswordUtils.hashPassword(userPwd).equals(user.getUserPwd())) {
					hasError = true;
					errorString = msgResponse.getHeader().getErrorDetail();
				}
			}
		}

		if (hasError) {
			
			logger.warn("Failed login attempt for user");
			
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);

			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
		
			MyUtils.storeLoginedUser(session, user);

			if (remember) {
				MyUtils.storeUserCookie(response, user);
			} else {
				MyUtils.deleteCookie(response);
			}
			logger.info("User logged in successfully!");
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

}
