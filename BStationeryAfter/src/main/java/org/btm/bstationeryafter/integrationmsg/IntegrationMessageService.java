package org.btm.bstationeryafter.integrationmsg;

import java.net.MalformedURLException;

import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.utils.ConfigReader;
import org.btm.bstationeryafter.utils.IntegrationMessageUtils;

public class IntegrationMessageService {
	
	// Login
	public static IntegrationMessage login(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserLogin(); // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePost(msg, apiUrl);
		return response;
	}
	
	
	// Sign up
	public static IntegrationMessage register(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserRegister(); // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePost(msg, apiUrl);
		return response;
	}
	
	
	// Get User By ID
	public static IntegrationMessage getUserById(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserGetById(); // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePost(msg, apiUrl);
		return response;
	}
	
	
	// Update Information
	public static IntegrationMessage updateInfo(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserUpdate(); // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePut(msg, apiUrl);
		return response;
	}
	
	
	// Update Password
	public static IntegrationMessage updatePassword(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserUpdatePassword(); // Adjust the API URL
//		String apiUrl = "http://localhost:9090/api/user/changepass/"; // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePut(msg, apiUrl);
		return response;
	}
	
	
	// Deactive User
	public static IntegrationMessage deactiveUser(IntegrationMessage msg) throws MalformedURLException {
		String apiUrl = ConfigReader.getApiUserPath() + ConfigReader.getApiUserDeactive(); // Adjust the API URL
//		String apiUrl = "http://localhost:9090/api/user/status"; // Adjust the API URL
		
		IntegrationMessage response = IntegrationMessageUtils.sendAndReceiveMessagePut(msg, apiUrl);
		return response;
	}
}
