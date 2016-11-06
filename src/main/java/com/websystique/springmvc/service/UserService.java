package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserService {

	User findById(int id);
	
	void saveUser(User User);
	
	void updateUser(User User);
	
	void deleteUserByName(String name);

	List<User> findAllUsers(); 
	
	User findUserByName(String name);

	boolean isUserNameUnique(Integer id, String name);
	
}
