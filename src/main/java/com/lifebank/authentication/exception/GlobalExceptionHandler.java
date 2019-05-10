package com.lifebank.authentication.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger log;
	private Environment env;
	
	@Autowired
	public GlobalExceptionHandler(Environment env){
		this.log = LoggerFactory.getLogger(getClass());
		this.env = env;
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value=ValidException.class)
	@ResponseBody
	public Object handleException(){

		return null;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=BlockException.class)
	@ResponseBody
	public Object handleExceptionBlocked(){

		return null;
	}

}