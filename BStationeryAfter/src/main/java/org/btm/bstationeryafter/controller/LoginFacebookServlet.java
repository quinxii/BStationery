package org.btm.bstationeryafter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.btm.bstationeryafter.utils.RestFB;

import com.restfb.types.User;

@WebServlet("/login-facebook")
public class LoginFacebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginFacebookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
	    
	    if (code == null || code.isEmpty()) {
	      RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
	      dis.forward(request, response);
	    } else {
	      String accessToken = RestFB.getToken(code);
	      User user = RestFB.getUserInfo(accessToken);
	      request.setAttribute("id", user.getId());
	      request.setAttribute("name", user.getName());
	      RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/view/homeView.jsp");
	      dis.forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
