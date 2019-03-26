package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	public String login() {
		int id =1;
		boolean res = loginManager.login(id);
		System.out.println("response "+res);
		
		return res==true ? "success":"failure";
	}
	
	

}
