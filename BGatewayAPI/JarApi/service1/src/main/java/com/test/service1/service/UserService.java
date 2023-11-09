package com.test.service1.service;

import java.util.List;

import com.test.service1.model.UserProfile;

public interface UserService {

	public UserProfile authenticate(String email,String userPwd);
	
	public UserProfile register(String email,String fullName,String userPwd,String phone,String gender,String dob);
	
	public UserProfile updatePassword(String email,String userPwd);
	
	public UserProfile updateUser(String email, String fullName,String phone,String dob);
	
	public UserProfile findUserByEmail(String email);
	
	public UserProfile deleteUserByEmail(String email,Boolean enabled);
	
	public List<UserProfile> getAll();
}
