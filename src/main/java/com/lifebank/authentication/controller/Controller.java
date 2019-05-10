package com.lifebank.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifebank.authentication.exception.BlockException;
import com.lifebank.authentication.exception.ValidException;
import com.lifebank.authentication.pojos.signin.RequestSignIn;
import com.lifebank.authentication.pojos.signin.ResponseSignIn;
import com.lifebank.authentication.process.SignInProcess;

@RestController
@PropertySource("classpath:configuration.properties")
@RequestMapping("${service.url}")
public class Controller {
	Environment env;
	SignInProcess process;
	
	@Autowired
	public Controller(Environment env, SignInProcess process){
		this.env = env;
		this.process = process;
	}
	
	@PostMapping("${service.url.endpoint.sign-in}")
	public ResponseSignIn singIn(@RequestBody RequestSignIn request) throws ValidException, BlockException{
		ResponseSignIn response;
		
			response = process.process(request);
			return response;
		
	}

}
