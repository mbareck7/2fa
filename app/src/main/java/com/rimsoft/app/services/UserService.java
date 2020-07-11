package com.rimsoft.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimsoft.app.entities.User;
import com.rimsoft.app.repositories.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;
	    
	    @Autowired
	    public void setUserRepos(UserRepo userRepo) {
	    	this.userRepo = userRepo;
	    }
	
	    public Iterable<User> getUsers(){
	    	return userRepo.findAll();
	    }
	    
	    public List<User>  getUserByName(String name){
	    	return userRepo.findByName(name);
	    }
}