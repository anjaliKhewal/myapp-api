package com.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.User;
import com.rest.api.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository repo;
	
	public boolean login(int id) {
		
		User user = repo.findById(id);
		System.out.println(user.getId()+"  "+ user.getUsername());
		
		boolean res =  user!=null ? true:false;
		return res;
	}
	
	

}
