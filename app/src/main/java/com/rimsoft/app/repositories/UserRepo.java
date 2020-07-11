package com.rimsoft.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rimsoft.app.entities.User;


public interface UserRepo extends CrudRepository<User, Integer>{

	List<User> findByName(String name);
}