//package org.btm.bstationeryafter.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.btm.bstationeryafter.model.GooglePojo;
//import org.btm.bstationeryafter.service.UserService;
//import org.btm.bstationeryafter.service.UserServiceImpl;
//import org.btm.bstationeryafter.utils.GoogleUtils;
//import org.btm.bstationeryafter.utils.MyUtils;
//
//import btm.com.core.model.UserProfile;
//
//
//@WebServlet("/login-google")
//public class LoginGoogleServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private UserService userService;
//
//	@Override
//    public void init() throws ServletException {
//        super.init();
//        userService = new UserServiceImpl(); 
//    }
//       
//    public LoginGoogleServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String code = request.getParameter("code");
//		HttpSession session = request.getSession();
//
//	    if (code == null) {
//	      RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
//	      dis.forward(request, response);
//	    } 
//	    else {
//	      String accessToken = GoogleUtils.getToken(code);
//	      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//	      String userId = googlePojo.getId();
//	        
//	      UserProfile user = new UserProfile();
//	      user = userService.authenticate(userId,null);
//	      if (user == null) {
//	    	  userService.register(userId, null, null, googlePojo.getEmail());
//	          MyUtils.storeLoginedUser(session, user);
//	          request.setAttribute("loginedUser", user);
//	       } 
//	       else {
//	    	   MyUtils.storeLoginedUser(session, user);
//	    	   request.setAttribute("loginedUser", user);
//	       }
//	      RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/homeView.jsp");
//	      dis.forward(request, response);
//	    }
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
