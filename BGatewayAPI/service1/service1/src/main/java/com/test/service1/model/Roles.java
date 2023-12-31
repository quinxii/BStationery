package com.test.service1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "[role]")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String role_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Roles(Integer id, String role_name) {
		this.id = id;
		this.role_name = role_name;
	}

	public Roles(Integer id) {
		this.id = id;
	}

	public Roles(String role_name) {
		this.role_name = role_name;
	}

	public Roles() {

	}
}
