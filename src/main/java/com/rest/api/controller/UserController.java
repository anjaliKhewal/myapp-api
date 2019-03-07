package com.rest.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping(value="/secured/user",method=RequestMethod.GET)
	public String authUser() {
		
		return "success";
	}
	
	@RequestMapping(value="/all/user",method=RequestMethod.GET)
	public String allUser() {
		
		return "success";
	}

}
