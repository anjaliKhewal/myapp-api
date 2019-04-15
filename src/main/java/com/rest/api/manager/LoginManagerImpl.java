package com.rest.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.api.service.LoginService;

@Component
public class LoginManagerImpl implements LoginManager{
	
	@Autowired
	LoginService loginService;
	
	public boolean login(String username,String password) {
		
		return loginService.login(username,password);
	}


}
