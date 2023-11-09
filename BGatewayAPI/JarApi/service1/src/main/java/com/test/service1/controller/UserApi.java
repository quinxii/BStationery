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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.test.service1.connect.UserConnect;
import com.test.service1.model.UserProfile;
import com.test.service1.service.UserService;

import btm.com.common.integrationmessage.IntegrationMessage;
import btm.com.common.integrationmessage.IntegrationMessageBody;
import btm.com.common.integrationmessage.IntegrationMessageHeader;
import btm.com.common.model.UserProfileMessage;

@RestController
public class UserApi {

	private static Logger logg = Logger.getLogger(UserApi.class);

	@Autowired
	UserService userService;

	@Autowired
	UserConnect userConnect;

	@GetMapping("/api/user/all")
	public IntegrationMessage getAllUser(@QueryParam("msg") String msg) {
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

	@GetMapping("/api/user/findbyid")
	public UserProfile getUserById(@QueryParam("email") String email) {
		UserProfile userCheck = userService.findUserByEmail(email);
		if (userCheck != null) {
			logg.info("Done");
			return userCheck;
		} else
			logg.info("Not Found");
		return null;
	}

	@PutMapping("/api/user/updatepassword/{email}")
	public UserProfile updatePassword(@PathVariable("email") String email, @QueryParam("usesPwd") String userPwd) {
		UserProfile userCheckPassword = userService.updatePassword(email, userPwd);
		if (userCheckPassword != null) {
			logg.info("Done");
			return userCheckPassword;
		} else
			logg.info("Not Found");
		return null;
	}

	@PutMapping("/api/user/updateuser/{email}")
	public UserProfile updateUser(@PathVariable("email") String email, @QueryParam("fullName") String fullName,
			@QueryParam("phone") String phone, @QueryParam("dob") String dob) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = df.parse(dob);
//			logg.info(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserProfile userCheck = userService.updateUser(email, fullName, phone, df.format(date));
		if (userCheck != null) {
			logg.info("Update Success");
			return userCheck;
		} else
			logg.info("Update Failed");
		return null;
	}

	@PutMapping("/api/user/delete")
	public UserProfile deleteUser(@QueryParam("email") String email, @QueryParam("enabled") Boolean enabled) {
		UserProfile userFindId = userService.deleteUserByEmail(email, enabled);
		if (userFindId != null) {
			logg.info("Done");
			return userFindId;
		} else
			logg.info("Not Found Email");
		return null;
	}
}
