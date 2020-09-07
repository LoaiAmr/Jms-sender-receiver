package com.testing.sender.springsenderapp.model;

import java.io.Serializable;

public class Employee extends ParentMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long empId;

	private String username;

	private String email;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String username, String email) {
		super();
		this.empId = empId;
		this.username = username;
		this.email = email;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", username=" + username + ", email=" + email + "]";
	}

}
