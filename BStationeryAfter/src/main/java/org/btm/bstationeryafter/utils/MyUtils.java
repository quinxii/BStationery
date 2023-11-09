package org.btm.bstationeryafter.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.btm.bstationeryafter.common.model.UserProfileMessage;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	// Store Connection in request attribute.
	// (Information stored only exist during requests)
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Get the Connection object has been stored in attribute of the request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Store user info in Session.
	public static void storeLoginedUser(HttpSession session, UserProfileMessage loginedUser) {
		// On the JSP can access via ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}

	// Get the user information stored in the session.
	public static UserProfileMessage getLoginedUser(HttpSession session) {
		UserProfileMessage loginedUser = (UserProfileMessage) session.getAttribute("loginedUser");
		return loginedUser;
	}

	// Store info in Cookie
	public static void storeUserCookie(HttpServletResponse response, UserProfileMessage user) {
		
		Cookie cookieuserId = new Cookie(ATT_NAME_USER_NAME, user.getEmail());
		// 1 day (Converted to seconds)
		cookieuserId.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieuserId);
	}

	public static String getuserIdInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Delete cookie.
	public static void deleteCookie(HttpServletResponse response) {
		Cookie cookieuserId = new Cookie(ATT_NAME_USER_NAME, null);
		// 0 seconds (This cookie will expire immediately)
		cookieuserId.setMaxAge(0);
		response.addCookie(cookieuserId);
	}
}
