package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.Client;

/**
 * This class is the interface of ClientDAO
 * 
 * @author gabrielbsanches
 *
 */
public interface ClientDAO {
 
	/**
	 * This method is to save Client in the system using sessionFactory
	 * 
	 * @param Client
	 */
	void add(Client client);
	
	/**
	 * This method first gets the client from the system by "findByClientId" and then
	 * set all values that are in this Client parameter object
	 * 
	 * @param Client
	 */
	void update(Client client);
	
	/**
	 * This method is to delete Client with it's ID from the system using sessionFactory
	 * 
	 * @param long
	 */
	void delete(long id);
	
	/**
	 * This method is to find Client by it's ID from the system using sessionFactory
	 * 
	 * @param 	long
	 * @return 	Client
	 */
	Client findByClientId(long id);
	
	/**
	 * This method is to return all Clients from the system
	 * 
	 * @return List<Client> clients
	 */
	List<Client> findAll();
	
	/**
	 * This method is to return all Company Names from the system (Client reality)
	 * 
	 * @return List<String> listOfClientCompanyNames
	 */
	List<String> findAllClientCompanyNames();
	
	/**
	 * This method is to return all Client Names from the system (Client reality)
	 * 
	 * @return List<String> listOfClientNames
	 */
	List<String> findAllClientNames();
 
}