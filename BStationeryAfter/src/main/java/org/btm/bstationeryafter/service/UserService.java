package org.btm.bstationeryafter.service;

import java.net.MalformedURLException;

import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;

import btm.com.core.model.UserProfile;

public interface UserService {
	
	public UserProfile authenticate(String email, String userPwd);
	
	public UserProfile register(String email, String fullname, String userPwd, String phone, String gender, String dob);

	public UserProfile getUserById(String email);
	
	public UserProfile updateUserInformation(String email, String fullname, String phone, String dob);

	public UserProfile updateUserPassword(String email, String userPwd);

	public UserProfile deactiveUser(String email, String enabled);
	
	public IntegrationMessage login(IntegrationMessage msg) throws MalformedURLException;

	public IntegrationMessage getUserById(IntegrationMessage msg) throws MalformedURLException;

	public IntegrationMessage register(IntegrationMessage msg) throws MalformedURLException;

	public IntegrationMessage updateInfo(IntegrationMessage msg) throws MalformedURLException;
	
	public IntegrationMessage updatePassword(IntegrationMessage msg) throws MalformedURLException;

	public IntegrationMessage deactiveUser(IntegrationMessage msg) throws MalformedURLException;
}
