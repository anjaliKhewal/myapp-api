package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.manager.LoginManager;

@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins = "http://localhost:4200")
public class MyAppController {
	
	@Autowired
	LoginManager loginManager;
	
	@RequestMapping(value ="/login", method =RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse login(
			@RequestHeader(value="username") String username,
			@RequestHeader(value="password") String password) {
		
		//int id =1;
		//id = !username.equalsIgnoreCase()")?1:0;
		boolean res = loginManager.login(username,password);
		System.out.println("response "+res);
		AuthResponse result = new AuthResponse();
		if(res) {
			result.setCode(0);
			result.setMessage("success");
		}
		else {
			result.setCode(10);
			result.setMessage("failure");
		}
		
		//return res==true ? "{"+"\"success\"}":"{"+"\"failure\"}";
		return result;
	}
	
	

}
