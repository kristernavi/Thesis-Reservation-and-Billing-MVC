package com.thesis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.AddOnDao;
import com.thesis.model.AddOn;
@Repository
public class AddOnDaoImpl implements AddOnDao {
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;

	@Override
	public void saveAddon(AddOn addon) {
		
		session.getCurrentSession().merge(addon);

	}

	@Override
	public void delete(long addOnId) {

		session.getCurrentSession().delete(this.getAddOn(addOnId));
	}

	@Override
	public AddOn getAddOn(long addOnId) {

		return (AddOn) session.getCurrentSession().get(AddOn.class, addOnId);
	}

	@Override
	public List<AddOn> getAllAddOn() {

		return session.getCurrentSession().createQuery("from AddOn").list();
	}

}
