package com.lifebank.authentication.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lifebank.authentication.exception.BlockException;
import com.lifebank.authentication.exception.ValidException;
import com.lifebank.authentication.pojos.signin.RequestSignIn;
import com.lifebank.authentication.pojos.signin.ResponseSignIn;

@Service
public class SignInProcess {
	
	Environment env;
	
	@Autowired
	public SignInProcess(Environment env){
		this.env = env;
	}
	
	public ResponseSignIn process(RequestSignIn request) throws ValidException, BlockException{
		
		ResponseSignIn response = new ResponseSignIn();
		String tkn = "";
		try{
			//Ir a la BDD
			if(env.getProperty("service.mock.username").equals(request.getUsername()) 
					&& env.getProperty("service.mock.password").equals(request.getPassword())){
				//Generar Tkn
				tkn = env.getProperty("service.mock.tkn");
			}else{
				//cuando la base responda con error, levantar exception
				throw new Exception();
			}
		}catch(Exception e){
			if("5".equals(env.getProperty("service.mock.intentos"))){
				throw new BlockException();
			} else{
				throw new ValidException();
			}
			
		}

		response.setTkn(tkn);
		
		return response;
	}
}
