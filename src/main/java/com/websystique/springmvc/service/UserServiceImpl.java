package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDaoImpl;
import com.websystique.springmvc.model.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public void saveUser(User User) {
		dao.saveUser(User);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User User) {
		User entity = dao.findById(User.getId());
		if(entity!=null){
			entity.setName(User.getName());
			entity.setWechatnumber(User.getWechatnumber());
			entity.setAddress(User.getAddress());
		}
	}

	
	
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public User findUserBywechatnumber(String wechatnumber) {
		return dao.findUserBywechatnumber(wechatnumber);
	}

	public boolean isUserNameUnique(Integer id, String name) {
		User User = findUserByName(name);
		return ( User == null || ((id != null) && (User.getId() == id)));
	}

	public void deleteUserByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
