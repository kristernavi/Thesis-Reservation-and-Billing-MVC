package com.thesis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.AddOnDetailDao;
import com.thesis.model.AddOnDetail;
@Repository
public class AddOnDetailDaoImpl implements AddOnDetailDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;

	@Override
	public void save(AddOnDetail addOnDetail) {

		session.getCurrentSession().merge(addOnDetail);
	}

	@Override
	public void delete(long id) {
		session.getCurrentSession().delete(getAddOnDetailById(id));

	}

	@Override
	public AddOnDetail getAddOnDetailById(long id) {
		return (AddOnDetail) session.getCurrentSession().get(AddOnDetail.class,id);

	}

	@Override
	public List getAllAddOnDetail() {
		return session.getCurrentSession().createQuery("from AddOnDetail").list();
	}
	@Transactional(readOnly=true)
	public List getAllAvailAddon(long occ_id){
		return session.getCurrentSession().createQuery("from AddOnDetail where occupancy.id ="+occ_id).list();
	}

}
