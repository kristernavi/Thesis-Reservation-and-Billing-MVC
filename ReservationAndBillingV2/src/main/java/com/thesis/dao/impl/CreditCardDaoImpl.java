package com.thesis.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.api.model.CreditCard;
import com.thesis.dao.CreditCardDao;
import com.thesis.model.User;
@Repository
public class CreditCardDaoImpl implements CreditCardDao {
	@Autowired
    @Qualifier(value="sessionFactory2")
	private SessionFactory session;

	@Override
	public void save(CreditCard creditCard) {
		session.getCurrentSession().merge(creditCard);
		
	}

	@Override
	public void delete(long id) {

		session.getCurrentSession().delete(getCreditCard(id));
	}

	@Override
	public CreditCard getCreditCard(long id) {

		return (CreditCard)session.getCurrentSession().get(CreditCard.class,id);
	}

	@Override
	public List getAllCreditCard() {

		return session.getCurrentSession().createQuery("from CreditCard").list();
	}

	@Override
	public CreditCard getByNumberCreditCard(long number) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(CreditCard.class);
		criteria.add(Restrictions.eq("number", number));	
		return (CreditCard)criteria.uniqueResult();
	}

}
