package com.primeit.client.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primeit.client.dao.UserDAO;
import com.primeit.client.model.User;

/**
 * This class implements the UserDAO
 * 
 * @author gabrielbsanches
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired private SessionFactory sessionFactory;
	
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		User userToUpdate = findByUserId(user.getUserid());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setLoginname(user.getLoginname());
		userToUpdate.setManager_name(user.getManager_name());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setPhone(user.getPhone());
		sessionFactory.getCurrentSession().update(userToUpdate);
	}

	public void delete(long id) {
		User user = findByUserId(id);
		if(user != null){
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	public User findByUserId(long id) {
		User user = (User)sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	public User findByUserAny(String userAny) {
		User user = (User)sessionFactory.getCurrentSession().get(User.class, userAny);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User").list();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findAllManagerNames(){
		  String sql = "SELECT u.manager_name FROM User u";
		  List<String> listOfManagerNames = sessionFactory.getCurrentSession().createQuery(sql).list();
		  return listOfManagerNames;
	  }

}
