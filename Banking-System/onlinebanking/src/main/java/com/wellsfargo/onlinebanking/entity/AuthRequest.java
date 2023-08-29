package com.wellsfargo.onlinebanking.entity;

public class AuthRequest {

	private String username;
	private String password;
	
	public AuthRequest() {
		super();
	}
	

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String userId) {
		this.username = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
