package com.test.service1.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserProfileMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

	private String userPwd;

	private String fullName;

	private boolean enabled = true;

	private Date createdAt;

	private Date updatedAt;

	private String phone;

	private Date dob;

	private boolean gender;

	private Set<RolesMessage> rolesMessage = new HashSet<>();

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<RolesMessage> getRoles() {
		return rolesMessage;
	}

	public void setRoles(Set<RolesMessage> rolesMessage) {
		this.rolesMessage = rolesMessage;
	}

	public void addRoles(RolesMessage rolesMessage) {
		this.rolesMessage.add(rolesMessage);
	}

}
