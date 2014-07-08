package com.primeit.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primeit.client.dao.ClientDAO;
import com.primeit.client.model.Client;
import com.primeit.client.service.ClientService;


@Transactional
@Service("ClientService")
public class ClientServiceImpl implements ClientService {

	@Autowired private ClientDAO clientDAO;

	public void add(Client client) {
		clientDAO.add(client);
	}

	public void update(Client client) {
		clientDAO.update(client);
	}

	public void delete(long id) {
		clientDAO.delete(id);
	}

	public Client findByClientId(long id) {
		return clientDAO.findByClientId(id);
	}

	public Client findByClientAny(String clientAny) {
		return clientDAO.findByClientAny(clientAny);
	}

	public List<Client> findAll() {
		return clientDAO.findAll();
	}
	
	public List<String> findAllClientCompanyNames(){
		return clientDAO.findAllClientCompanyNames();
	}
	
	public List<String> findAllClientNames(){
		return clientDAO.findAllClientNames();
	}
	
}
