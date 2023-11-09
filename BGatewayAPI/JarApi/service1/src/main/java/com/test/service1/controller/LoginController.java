package com.test.service1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.test.service1.model.UserProfile;
import com.test.service1.service.UserService;

import btm.com.common.integrationmessage.IntegrationMessage;
import btm.com.common.integrationmessage.IntegrationMessageBody;
import btm.com.common.integrationmessage.IntegrationMessageHeader;
import btm.com.common.model.UserProfileMessage;



@RestController
public class LoginController {
	
	private static Logger logg = Logger.getLogger(LoginController.class);

	@Autowired
	UserService userService;
	
	@GetMapping("/api/user/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/api/user/login")
	public IntegrationMessage postLogin(@QueryParam("msg") String msg) {
		IntegrationMessage msgRequest = new IntegrationMessage();
		IntegrationMessageBody body = new IntegrationMessageBody();
		IntegrationMessageHeader header = new IntegrationMessageHeader();
			
	if (null == msg || msg.isEmpty()) {
		header.setERRORCODE("USR001");
		msgRequest.setHeader(header);
		return msgRequest;
	}

	try {
		Gson gson = new Gson();
		// Get data from client request
		msgRequest = gson.fromJson(msg, IntegrationMessage.class);
		// Extract data from msgRequest based on your desired
		List<UserProfileMessage> userProfileMessage = msgRequest.getBody().getUserProfile();

		if (userProfileMessage == null || userProfileMessage.size() == 0) {
			// Invalid data (bad data)
			header.setERRORCODE("USR003");
			msgRequest.setHeader(header);
			return msgRequest;
		}

		if (userProfileMessage != null || userProfileMessage.size() > 0) {
			/*
			 * UserProfileMessage userProfileMessageList = userProfileMessage.get(0);
			 * body.setUserProfile(userProfileMessage); msgRequest.setBody(body);
			 * IntegrationMessage transform = userConnect.getAllUser(msg);
			 */
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/all");
			request.queryParameter("msg", msg);
			
			ClientResponse<IntegrationMessage> response = request.get(IntegrationMessage.class);
			msgRequest = response.getEntity();
			header.setERRORCODE("USR004");
			msgRequest.setHeader(header);
			return msgRequest;
		}
	} catch (Exception e) {
		header.setERRORCODE("USR002" + e.getMessage());
		msgRequest.setHeader(header);
	}
	return msgRequest;
	}
	
	@GetMapping("/api/user/register")
	public String getRegister() {
		return "register";
	}

	@PostMapping("/api/user/register")
	public UserProfile postRegister(@QueryParam("email") String email,
			@QueryParam("fullName")String fullName,
			@QueryParam("userPwd")String userPwd,
			@QueryParam("phone")String phone,
			@QueryParam("gender")String gender,
			@QueryParam("dob")String dob) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = df.parse(dob);
			logg.info(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserProfile userRegister = userService.register(email, fullName, userPwd, phone, gender, df.format(date));
//		String date = userForm.getDob().toString();
		
		if (userRegister != null) {
			logg.info("Register Success");
			return userRegister;
		} else
			logg.info("Register Failed");
		return null;
	}
}
