package com.thesis.dao.impl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.GuestDao;
import com.thesis.model.Guest;

@Repository
public class GuestDaoImpl implements GuestDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	@Override
	public void saveGuest(Guest guest) {
		session.getCurrentSession().merge(guest);

	}

	@Override
	public void edit(Guest guest) {
		session.getCurrentSession().update(guest);

	}

	@Override
	public void delete(long guestId) {
		session.getCurrentSession().delete(getGuest(guestId));

	}

	@Override
	public Guest getGuest(long guestId) {
		
		return (Guest)session.getCurrentSession().get(Guest.class, guestId);
	}

	@Override
	public List<Guest> getAllGuest() {
		
		return session.getCurrentSession().createQuery("from Guest").list();
	}

}
