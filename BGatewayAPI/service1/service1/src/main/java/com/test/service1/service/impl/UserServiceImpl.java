package com.test.service1.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.test.service1.model.UserProfile;
import com.test.service1.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Override
	public UserProfile authenticate(String email, String userPwd) {
		UserProfile userAuthenticate = new UserProfile();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/authenticate");
			request.queryParameter("email", email);
			request.queryParameter("userPwd", userPwd);
			
			ClientResponse<UserProfile> response = request.post(UserProfile.class);
			userAuthenticate = response.getEntity();
			boolean isSuccess = false;
			if(userAuthenticate.getEmail() != null) {
				isSuccess = true;
				System.out.println("Login Success "+isSuccess);
			}
		}  catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userAuthenticate;
	}

	

	@Override
	public UserProfile updatePassword(String email, String userPwd) {
		UserProfile updatePassword = new UserProfile();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/changepass");
			request.pathParameter("email", email);
			request.queryParameter("userPwd", userPwd);
			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			updatePassword = response.getEntity();
			boolean isSuccess = false;
			if(updatePassword.getEmail() != null) {
				isSuccess = true;
				System.out.println("Update Password Success " +isSuccess);
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return updatePassword;
	}

	
	@Override
	public UserProfile findUserByEmail(String email) {
		UserProfile userByEmail = new UserProfile();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user");
			request.queryParameter("email", email);

			
			ClientResponse<UserProfile> response = request.get(UserProfile.class);
			userByEmail = response.getEntity();
			boolean isSuccess = false;
			if(userByEmail.getEmail() != null) {
				isSuccess = true;
				System.out.println("Find User Success " +isSuccess);
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return userByEmail;
	}



	@Override
	public UserProfile register(String email, String fullName, String userPwd, String phone, String gender, String dob) {
		UserProfile userCheckRegister = new UserProfile();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/register");
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("email", email);
			request.queryParameter("fullName", fullName);
			request.queryParameter("userPwd", userPwd);
			request.queryParameter("phone", phone);
			request.queryParameter("gender", gender);
			request.queryParameter("dob", dob);
			
			ClientResponse<UserProfile> response = request.post(UserProfile.class);
			userCheckRegister = response.getEntity();
			boolean isSuccess = false;
			if(userCheckRegister.getEmail() != null) {
				isSuccess = true;
			}
			System.out.println("Find User Success " +isSuccess);
		} catch (MalformedURLException e) {

			

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userCheckRegister;
	}



	@Override
	public UserProfile updateUser(String email, String fullName, String phone,String dob) {
		UserProfile userCheckUpdateUser = new UserProfile();
		
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/updateinfo/{email}");
			request.accept(MediaType.APPLICATION_JSON);
			request.pathParameter("email", email);
			request.queryParameter("fullName", fullName);
			request.queryParameter("phone", phone);
			request.queryParameter("dob", dob);
			
			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			userCheckUpdateUser = response.getEntity();
			boolean isSuccess = false;
			if(userCheckUpdateUser.getEmail() != null) {
				isSuccess = true;
				System.out.println("Find User Success " +isSuccess);
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userCheckUpdateUser;
	}



	@Override
	public UserProfile deleteUserByEmail(String email,Boolean enabled) {
		UserProfile userCheckEmail = new UserProfile();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/status");
			request.queryParameter("email", email);
			request.queryParameter("enabled", enabled);
			
			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			userCheckEmail = response.getEntity();
			boolean isSuccess = false;
			if(userCheckEmail.getEmail() != null) {
				isSuccess = true;
				System.out.println("Delete User Success " +isSuccess);
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userCheckEmail;
	}



	@Override
	public List<UserProfile> getAll() {
//		try {
//			ClientRequest request = new ClientRequest("http://localhost:9090/api/user/all");
//			
//			ClientResponse<UserProfile> response = request.get(UserProfile.class);
//			List<UserProfile> userCheck = new ArrayList<UserProfile>();
//			userCheck = response.getEntity();
//	//		String json = response.getEntity().toString();
//	//		Gson gson = new Gson();
//	//		List<UserProfile> obj = (List<UserProfile>) gson.fromJson(json, UserProfile.class);
//			boolean isSuccess = false;
//			if(obj != null) {
//				integrationResponseBody.setUserProfile(obj);
//				isSuccess = true;
//				integrationResponseMessage.setIntegrationResponseBody(integrationResponseBody);
//				System.out.println("Get User Success " +isSuccess);
//			}
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
		return null;
	}
	
}
