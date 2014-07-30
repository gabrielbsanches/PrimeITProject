package com.primeit.client.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeit.client.dao.UserDAO;
import com.primeit.client.model.User;
import com.primeit.client.service.UserService;

/**
 * This class implements UserService
 * 
 * @author Gabriel Sanches
 *
 */
@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired private UserDAO userDAO;

	public void add(User user) {
		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		/*
		 * Encrypt the password
		 */
		if(!user.getPassword().isEmpty()){
			user.setPassword(encryptByHashing(user.getPassword()));
		}
		userDAO.add(user);
	}
	
	

	public void update(User user) {
		user.setPassword(encryptByHashing(user.getPassword()));
		userDAO.update(user);
	}

	public void delete(long id) {
		userDAO.delete(id);
	}

	public User findByUserId(long id) {
		return userDAO.findByUserId(id);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	public List<String> findAllManagerNames(){
		return userDAO.findAllManagerNames();
	}
	
	
	/**
	 * Method to Encrypt the password via SHA algorithm.
	 * 
	 * @param 	String password
	 * @return	password encrypted
	 */
	private static String encryptByHashing(String password){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			 
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format 
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error Method[ EncryptByHashing with SHA-1 ] "+e.getMessage());
			e.printStackTrace();
		}
        
		return password;
	}
}
