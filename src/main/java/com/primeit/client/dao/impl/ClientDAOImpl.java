package com.primeit.client.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.primeit.client.dao.ClientDAO;
import com.primeit.client.model.Client;
 
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ClientDAOImpl implements ClientDAO{
	
	 @Autowired private SessionFactory sessionFactory;
 
	public void add(Client client){
		sessionFactory.getCurrentSession().save(client);
	}
 
	public void update(Client client){
		Client clientToUpdate = findByClientId(client.getClient_id());
		clientToUpdate.setClient_code(client.getClient_code());
		clientToUpdate.setClient_company_name(client.getClient_company_name());
		clientToUpdate.setClient_name(client.getClient_name());
		clientToUpdate.setClient_comment(client.getClient_comment());
		clientToUpdate.setLast_date(client.getLast_date());
		clientToUpdate.setEmail(client.getEmail());
		clientToUpdate.setPhone(client.getPhone());
		sessionFactory.getCurrentSession().update(clientToUpdate);
	}
	
	public Client findByClientId(long id){
		Client client = (Client)sessionFactory.getCurrentSession().get(Client.class, id);
		return client;
	}
 
	public void delete(long id){
		Client client = findByClientId(id);
		if(client != null){
			sessionFactory.getCurrentSession().delete(client);
		}
	}
 
	public Client findByClientAny(String clientAny){
		Client client = (Client)sessionFactory.getCurrentSession().get(Client.class, clientAny);
		return client;
	}
	
	 /**
	   * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
	   * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
	   */
	  @Transactional
	  public List<Client> findAll() {
	    Session session = sessionFactory.getCurrentSession();
	    List clients = session.createQuery("from Client").list();
	    return clients;
	  }
	  
	  public List<String> findAllClientCompanyNames(){
		  String sql = "SELECT c.client_company_name FROM Client c";
		  List listOfClientCompanyNames = sessionFactory.getCurrentSession().createQuery(sql).list();
		  return listOfClientCompanyNames;
	  }
	  
	  public List<String> findAllClientNames(){
		  String sql = "SELECT c.client_name FROM Client c";
		  List listOfClientCompanyNames = sessionFactory.getCurrentSession().createQuery(sql).list();
		  return listOfClientCompanyNames;
	  }
 
}