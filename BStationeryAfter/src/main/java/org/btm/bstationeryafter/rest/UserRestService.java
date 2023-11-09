package org.btm.bstationeryafter.rest;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ws.rs.core.MediaType;

import org.btm.bstationeryafter.utils.ConfigReader;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import btm.com.core.model.UserProfile;

public class UserRestService {
	
	// USER MANAGEMENT
	// Used for LOGIN FUNCTION
	public static UserProfile callRestApiForLogin(String email, String userPwd) {
		UserProfile userModel = new UserProfile();
		
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserLogin());
			request.accept(MediaType.APPLICATION_JSON);
			
			request.queryParameter("email", email);
			request.queryParameter("userPwd", userPwd);

			ClientResponse<UserProfile> response = request.post(UserProfile.class);
			
			userModel = response.getEntity();
			boolean isSuccess = false;
			if(userModel.getEmail() != null) {
				isSuccess = true;
			}
			System.out.println("Login result: " + isSuccess);
			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return userModel;
	}

	// Used for REGISTER FUNCTION
	public static UserProfile callRestApiForRegister(String email, String fullname, String userPwd, String phone, String gender, String dob) {
		UserProfile userModel = new UserProfile();
			
			try {
				ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserRegister());
				request.accept(MediaType.APPLICATION_JSON);
				request.queryParameter("email", email);
				request.queryParameter("fullName", fullname);
				request.queryParameter("userPwd", userPwd);
				request.queryParameter("phone", phone);
				request.queryParameter("gender", gender);
				request.queryParameter("dob", dob);

				ClientResponse<UserProfile> response = request.post(UserProfile.class);
				
				userModel = response.getEntity();
				boolean isSuccess = false;
				if(userModel.getEmail() != null) {
					isSuccess = true;
				}
				System.out.println("Register result: " + isSuccess);
				
			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} catch (Exception e) {

				e.printStackTrace();

			}

			return userModel;
		}

	// Used for GET USER BY ID FUNCTION
	public static UserProfile callRestApiForGetUserById(String email) {
		UserProfile userModel = new UserProfile();
		
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserGetById());
			
			request.queryParameter("email", email);
			
			ClientResponse<UserProfile> response = request.get(UserProfile.class);
			userModel = response.getEntity();
			if(userModel.getEmail() == null) {
				userModel = null;
			}
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return userModel;
	}
	
	// Used for UPDATE INFORMATION FUNCTION
	public static UserProfile callRestApiForUpdateInformation(String email, String fullname, String phone, String dob) {
		UserProfile userModel = null;
		
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserUpdate()+"/"+email);
			
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("fullName", fullname);
			request.queryParameter("phone", phone);
			request.queryParameter("dob", dob);
			
			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			
			userModel = response.getEntity();
			
			boolean isSuccess = false;
			if(userModel.getEmail() != null) {
				isSuccess = true;
			}
			System.out.println("Update User result: " + isSuccess);
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return userModel;
	}
		
	// Used for UPDATE PASSWORD FUNCTION
	public static UserProfile callRestApiForUpdatePassword(String email, String userPwd) {
		UserProfile userModel = null;
			
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserUpdatePassword()+"/"+email);
			
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("userPwd", userPwd);

			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			
			userModel = response.getEntity();
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return userModel;
	}
	
	// Used for DELETE USER FUNCTION
	public static UserProfile callRestApiForDeactiveUser(String email, String enabled) {
		UserProfile userModel = null;
		
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiUserPath()+ConfigReader.getApiUserDeactive());
			
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("email", email);
			request.queryParameter("enabled", enabled);

			ClientResponse<UserProfile> response = request.put(UserProfile.class);
			
			userModel = response.getEntity();
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return userModel;
	}

}
