package com.durgesh;

import org.springframework.stereotype.Component;

@Component

public class AuthRequest {

	private String email;
	private String password;

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

	@Override
	public String toString() {
		return "AuthRequest [userName=" + email + ", password=" + password + "]";
	}

	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
