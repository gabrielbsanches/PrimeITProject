package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.User;

public interface UserDAO {
	
	public void add(User user);
	void update(User user);
	void delete(long id);
	User findByUserId(long id);
	User findByUserAny(String userAny);
	List<User> findAll();
	List<String> findAllManagerNames();
}
