package com.rest.api.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping(value="/secured/user",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse authUser() {

		return new AuthResponse(0, "success");
	}
	
	@RequestMapping(value="/all/user",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse allUser() {
		
		return new AuthResponse(0, "success");
	}

}
