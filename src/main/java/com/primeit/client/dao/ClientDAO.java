package com.primeit.client.dao;

import java.util.List;

import com.primeit.client.model.Client;

public interface ClientDAO {
 
	void add(Client client);
	void update(Client client);
	void delete(long id);
	Client findByClientId(long id);
	Client findByClientAny(String clientAny);
	List<Client> findAll();
	List<String> findAllClientCompanyNames();
	List<String> findAllClientNames();
 
}