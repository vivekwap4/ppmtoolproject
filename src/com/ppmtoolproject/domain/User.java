package com.ppmtoolproject.domain;

public class User {
	private String name;
	private String email; //primary key
	private String password;
	private String userType;

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
