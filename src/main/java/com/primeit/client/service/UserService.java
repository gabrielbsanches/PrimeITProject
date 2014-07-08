package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.User;

public interface UserService {

	public void add(User user);
	public void update(User user);
	public void delete(long id);
	public User findByUserId(long id);
	public User findByUserAny(String userAny);
	public List<User> findAll();
	public List<String> findAllManagerNames();
}
