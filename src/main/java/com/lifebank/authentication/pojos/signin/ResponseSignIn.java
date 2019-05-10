package com.lifebank.authentication.pojos.signin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSignIn {

	@JsonProperty("tkn")
	String tkn;

	@JsonProperty("tkn")
	public String getTkn() {
		return tkn;
	}

	@JsonProperty("tkn")
	public void setTkn(String tkn) {
		this.tkn = tkn;
	}
	
	
}
