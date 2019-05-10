package com.lifebank.authentication.pojos.signin;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RequestSignIn {

	@JsonProperty("username")
	String username;
	@JsonProperty("password")
	String password;
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
