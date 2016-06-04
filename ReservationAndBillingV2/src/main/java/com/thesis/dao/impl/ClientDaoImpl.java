package com.thesis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.ClientDao;
import com.thesis.model.Client;
@Repository
public class ClientDaoImpl implements ClientDao {
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;

	@Override
	public void save(Client client) {
		session.getCurrentSession().save(client);
		
	}

	@Override
	public void delete(long id) {

		session.getCurrentSession().delete(this.getClient(id));
	}

	@Override
	public Client getClient(long id) {

		return (Client) session.getCurrentSession().get(Client.class, id);
	}

	@Override
	public List getAllClient() {
		return session.getCurrentSession().createQuery("from Billing").list();

		
	}

}
