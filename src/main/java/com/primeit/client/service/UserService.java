package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.User;

/**
 * This class is the User Service
 * 
 * @author gabrielbsanches
 *
 */
public interface UserService {

	/**
	 * This method is to save User in the system, setting:
	 * Enable = true
	 * Authority = ROLE_USER
	 * Password = Encrypt via SHA algorithm
	 * 
	 * @param User
	 */
	public void add(User user);
	
	/**
	 * This method is to update User in the system, setting:
	 * Password = Encrypt via SHA algorithm
	 * 
	 * @param User
	 */
	public void update(User user);
	
	/**
	 * This method is to delete User with it's ID from the system
	 * 
	 * @param long
	 */
	public void delete(long id);
	
	/**
	 * This method is to find User by it's ID from the system
	 * 
	 * @param 	long
	 * @return 	User
	 */
	public User findByUserId(long id);
	
	/**
	 * This method is to return all Users from the system
	 * 
	 * @return List<User> users
	 */
	public List<User> findAll();
	
	/**
	 * This method is to return all User Names from the system (User reality)
	 * 
	 * @return List<String> listOfUserNames
	 */
	public List<String> findAllManagerNames();
}
