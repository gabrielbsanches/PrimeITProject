package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.Client;

/**
 * This class is the Client Service
 * 
 * @author gabrielbsanches
 *
 */
public interface ClientService {
	
	/**
	 * This method is to save Client in the system
	 * 
	 * @param Client
	 */
	public void add(Client client);
	
	/**
	 * This method is to update Client in the system
	 * 
	 * @param Client
	 */
	public void update(Client client);
	
	/**
	 * This method is to delete Client with it's ID from the system
	 * 
	 * @param long
	 */
	public void delete(long id);
	
	/**
	 * This method is to find Client by it's ID from the system
	 * 
	 * @param 	long
	 * @return 	Client
	 */
	public Client findByClientId(long id);
	
	/**
	 * This method is to return all Clients from the system
	 * 
	 * @return List<Client> clients
	 */
	public List<Client> findAll();
	
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
