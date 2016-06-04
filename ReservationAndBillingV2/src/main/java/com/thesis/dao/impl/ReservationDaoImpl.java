package com.thesis.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.ReservationDao;
import com.thesis.model.Reservation;
@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	@Override
	public void save(Reservation reservation) {
		session.getCurrentSession().save(reservation);

	}

	@Override
	public void delete(long id) {

		session.getCurrentSession().delete(this.getReservation(id));
	}

	@Override
	public Reservation getReservation(long id) {

		return (Reservation) session.getCurrentSession().get(Reservation.class, id);
	}

	@Override
	public List getAllReservation() {

		return session.getCurrentSession().createQuery("from Reservation").list();
	}

	@Override
	public Reservation getReservationByReference(String key) {
		Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
		Criteria criteria = session.getCurrentSession().createCriteria(Reservation.class);
		criteria.add(Restrictions.ge("reserveDate", yesterday));
		criteria.add(Restrictions.le("reserveDate", new Date()));
		criteria.add(Restrictions.eq("reference", key));
		return (Reservation) criteria.uniqueResult();
	}

}
