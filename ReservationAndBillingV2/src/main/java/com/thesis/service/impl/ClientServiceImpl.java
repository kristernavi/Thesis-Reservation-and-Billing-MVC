package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.ClientDao;
import com.thesis.model.Client;
import com.thesis.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	@Transactional
	public void save(Client client) {

		clientDao.save(client);
		
	}

	@Override
	@Transactional
	public void delete(long id) {

		clientDao.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Client getClient(long id) {

		return clientDao.getClient(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllClient() {

		return clientDao.getAllClient();
	}

}
