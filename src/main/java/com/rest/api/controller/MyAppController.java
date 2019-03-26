package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.manager.LoginManager;

@RestController
@RequestMapping("/myapp")
public class MyAppController {
	
	@Autowired
	LoginManager loginManager;
	
	@RequestMapping(value ="/login", method =RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String login(
			@RequestHeader(value="username") String username,
			@RequestHeader(value="password") String password) {
		
		//int id =1;
		//id = !username.equalsIgnoreCase()")?1:0;
		boolean res = loginManager.login(username);
		System.out.println("response "+res);
		
		return res==true ? "success":"failure";
	}
	
	

}
