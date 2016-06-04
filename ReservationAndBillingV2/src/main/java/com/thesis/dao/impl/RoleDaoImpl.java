package com.thesis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.RoleDao;
import com.thesis.model.Role;


@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	SessionFactory session;

	@Override
	public List<Role> getAllRole() {
		return session.getCurrentSession().createQuery("from Roles").list();
	}

	
	

}
