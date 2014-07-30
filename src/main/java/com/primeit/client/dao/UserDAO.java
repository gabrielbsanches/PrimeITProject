package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.User;

/**
 * This class is the interface of UserDAO
 * 
 * @author gabrielbsanches
 *
 */
public interface UserDAO {
	
	/**
	 * This method is to save User in the system using sessionFactory
	 * 
	 * @param User
	 */
	public void add(User user);
	
	/**
	 * This method first gets the user from the system by "findByUserId" and then
	 * set all values that are in this User parameter object
	 * 
	 * @param User
	 */
	void update(User user);
	
	/**
	 * This method is to delete User with it's ID from the system using sessionFactory
	 * 
	 * @param long
	 */
	void delete(long id);
	
	/**
	 * This method is to find User by it's ID from the system using sessionFactory
	 * 
	 * @param 	long
	 * @return 	User
	 */
	User findByUserId(long id);

	/**
	 * This method is to return all Users from the system
	 * 
	 * @return List<User> users
	 */
	List<User> findAll();
	
	/**
	 * This method is to return all User Names from the system (User reality)
	 * 
	 * @return List<String> listOfUserNames
	 */
	List<String> findAllManagerNames();
}
