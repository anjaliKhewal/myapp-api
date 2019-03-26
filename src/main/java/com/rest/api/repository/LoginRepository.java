package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.model.User;

public interface LoginRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
	User findByUsername(String username);
}
