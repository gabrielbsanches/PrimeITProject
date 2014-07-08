package com.primeit.client.service;

import java.util.List;

import com.primeit.client.model.Client;

public interface ClientService {
	
	public void add(Client client);
	public void update(Client client);
	public void delete(long id);
	public Client findByClientId(long id);
	public Client findByClientAny(String clientAny);
	public List<Client> findAll();
	List<String> findAllClientCompanyNames();
	List<String> findAllClientNames();

}
