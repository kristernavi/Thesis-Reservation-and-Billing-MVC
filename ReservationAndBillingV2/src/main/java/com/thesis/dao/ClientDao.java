package com.thesis.dao;

import java.util.List;

import com.thesis.model.Client;

public interface ClientDao {
	
	public void save(Client client);
	public void delete(long id);
	public Client getClient(long id);
	public List getAllClient();

}
