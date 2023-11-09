package org.btm.bstationeryafter.service;

import java.net.MalformedURLException;

import org.btm.bstationeryafter.common.integrationmsg.IntegrationMessage;
import org.btm.bstationeryafter.integrationmsg.IntegrationMessageService;
import org.btm.bstationeryafter.rest.UserRestService;

import btm.com.core.model.UserProfile;

public class UserServiceImpl implements UserService {
	
	@Override
	public UserProfile authenticate(String userId, String userPwd) {
		UserProfile userProfile = UserRestService.callRestApiForLogin(userId, userPwd);
		return userProfile;
	}
	
	@Override
	public UserProfile register(String email, String fullname, String userPwd, String phone, String gender, String dob) {
		UserProfile userProfile = UserRestService.callRestApiForRegister(email, fullname, userPwd, phone, gender, dob);
		return userProfile;
	}

	@Override
	public UserProfile getUserById(String email) {
		UserProfile userProfile = UserRestService.callRestApiForGetUserById(email);
		return userProfile;
	}

	@Override
	public UserProfile updateUserInformation(String email, String fullname, String phone, String dob) {
		UserProfile userProfile = UserRestService.callRestApiForUpdateInformation(email,fullname,phone,dob);
		return userProfile;
	}

	@Override
	public UserProfile updateUserPassword(String email, String userPwd) {
		UserProfile userProfile = UserRestService.callRestApiForUpdatePassword(email,userPwd);
		return userProfile;
	}

	@Override
	public UserProfile deactiveUser(String email, String enabled) {
		UserProfile userProfile = UserRestService.callRestApiForDeactiveUser(email,enabled);
		return userProfile;
	}

	@Override
	public IntegrationMessage login(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.login(msg);
		return message;
	}

	@Override
	public IntegrationMessage getUserById(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.getUserById(msg);
		return message;
	}

	@Override
	public IntegrationMessage register(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.register(msg);
		return message;
	}

	@Override
	public IntegrationMessage updateInfo(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.updateInfo(msg);
		return message;
	}

	@Override
	public IntegrationMessage updatePassword(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.updatePassword(msg);
		return message;
	}

	@Override
	public IntegrationMessage deactiveUser(IntegrationMessage msg) throws MalformedURLException {
		IntegrationMessage message = IntegrationMessageService.deactiveUser(msg);
		return message;
	}
}
