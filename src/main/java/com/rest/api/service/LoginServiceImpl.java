package com.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.User;
import com.rest.api.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository repo;
	
	public boolean login(String username,String password) {
		
		//User user = repo.findById(id);
		boolean res = false;
		User user = repo.findByUsername(username);
		if(user!=null && user.getPassword().equals(password)) {
		System.out.println(user.getId()+"  "+ user.getUsername()+" "+user.getPassword());
		res = true;
		}else {
		res = false;
		}
		
		return res;
	}
	
	

}
