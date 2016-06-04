package com.thesis.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.RoomDao;
import com.thesis.model.Occupancy;
import com.thesis.model.Room;
import com.thesis.model.RoomReservation;
import com.thesis.model.RoomStatus;
import com.thesis.model.SearchReportDate;

@Repository
public class RoomDaoImpl implements RoomDao {
	
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	

	@Override
	public void addRoom(Room room) {
		session.getCurrentSession().merge(room);

	}

	@Override
	public void editRoom(Room room) {
		session.getCurrentSession().update(room);

	}

	@Override
	public void deleteRoom(long room_no) {
		session.getCurrentSession().delete(getRoom(room_no));

	}

	@Override
	public Room getRoom(long room_no) {
		
		return (Room)session.getCurrentSession().get(Room.class, room_no);
	}
	


	@Override
	public List<Room> getAllRoom() {
		
		return session.getCurrentSession().createQuery("from Room order by type").list();
	}

	@Override
	public List getAvailableRoom(Date from, Date to) {
	


		DetachedCriteria reserveSubquery = DetachedCriteria.forClass(Occupancy.class, "occ");
		
		reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", from), Restrictions.gt("from", to))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		reserveSubquery.add(Restrictions.eq("status", "CHECK_IN"));
		reserveSubquery.setProjection(Projections.property("room.id"));

		DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(RoomReservation.class, "rr");
		
		reserveSubquery2.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", from), Restrictions.gt("from", to))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		reserveSubquery2.setProjection(Projections.property("room.id"));
		
		Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
		criteria.add(Restrictions.eq("status", RoomStatus.ACTIVE));
		criteria.addOrder(Order.asc("type"));
		criteria.add(Subqueries.propertyNotIn("id", reserveSubquery2));
		criteria.add(Subqueries.propertyNotIn("id", reserveSubquery));
		
		
		
		return criteria.list();






		
	}
	
	
	public List getRoomHaveTranscation() {
		
		DetachedCriteria reserveSubquery = DetachedCriteria.forClass(RoomReservation.class, "reserve");
		
		//reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("check_out", check_in), Restrictions.gt("check_in", check_out))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		
		reserveSubquery.setProjection(Projections.property("room.id"));
DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(Occupancy.class, "occ");
		
		//reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("check_out", check_in), Restrictions.gt("check_in", check_out))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		
		reserveSubquery2.setProjection(Projections.property("room.id"));
		Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
		criteria.add(Restrictions.or(Subqueries.propertyIn("id", reserveSubquery2), Subqueries.propertyIn("id", reserveSubquery)));
		criteria.addOrder(Order.asc("type"));
		
		
		
		return criteria.list();
		
		/*return session.getCurrentSession().createQuery("from Room r  where r.room_id not in ( from "
				+ " Reservation rv ").list();*/
		
		/*Criteria criteria = session.getCurrentSession().createCriteria(Room.class)
			    .add(Subqueries.propertyNotIn("id", DetachedCriteria.forClass(Reservation.class)
			        .createAlias("room", "rr")
			        .setProjection(Property.forName("rr.id"))
			    ));
		return criteria.list();*/
		
	}
	
public int checkIfAvailable(Date check_in, Date check_out, long id) {
		check_in.setHours(12);
		check_out.setHours(12);
		System.out.println(check_in);
		System.out.println(check_out);
		DetachedCriteria reserveSubquery = DetachedCriteria.forClass(RoomReservation.class, "rr");
		
		reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", check_in), Restrictions.gt("from", check_out))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		reserveSubquery.setProjection(Projections.property("room.id"));
DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(Occupancy.class, "occ");
		
		reserveSubquery2.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", check_in), Restrictions.gt("from", check_out))));
		//reserveSubquery.add(Restrictions.or(lhs, rhs));
		reserveSubquery2.add(Restrictions.eq("status", "CHECK_IN"));
		reserveSubquery2.setProjection(Projections.property("room.id"));
		
		Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
		criteria.add(Subqueries.propertyNotIn("id", reserveSubquery));
		criteria.add(Subqueries.propertyNotIn("id", reserveSubquery2));
		criteria.add(Restrictions.eq("id", id));
		
		criteria.setProjection(Projections.rowCount());
		Integer count = (Integer) criteria.uniqueResult();
		
		return count;
		
		
	}


public List getAvailableEditRoom(Date from, Date to,long id, BigDecimal rate) {
	


	DetachedCriteria reserveSubquery = DetachedCriteria.forClass(Occupancy.class, "occ");
	
	reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", from), Restrictions.gt("from", to))));
	//reserveSubquery.add(Restrictions.or(lhs, rhs));
	reserveSubquery.add(Restrictions.eq("status", "CHECK_IN"));
	reserveSubquery.setProjection(Projections.property("room.id"));

	DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(RoomReservation.class, "rr");
	
	reserveSubquery2.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", from), Restrictions.gt("from", to))));
	//reserveSubquery.add(Restrictions.or(lhs, rhs));
	reserveSubquery2.add(Restrictions.ne("reserve.id", id));
	reserveSubquery2.setProjection(Projections.property("room.id"));
	
	Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
	criteria.add(Restrictions.le("rate", rate));
	criteria.add(Restrictions.eq("status", RoomStatus.ACTIVE));
	criteria.addOrder(Order.asc("type"));
	criteria.add(Subqueries.propertyNotIn("id", reserveSubquery2));
	criteria.add(Subqueries.propertyNotIn("id", reserveSubquery));
	
	
	
	return criteria.list();






	
}

@Override
public int checkIfAvailableEdit(Date check_in, Date check_out, long id, long reserve_id) {

	DetachedCriteria reserveSubquery = DetachedCriteria.forClass(Occupancy.class, "occ");
	
	reserveSubquery.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", check_in), Restrictions.gt("from", check_out))));
	//reserveSubquery.add(Restrictions.or(lhs, rhs));
	reserveSubquery.add(Restrictions.eq("status", "CHECK_IN"));
	reserveSubquery.setProjection(Projections.property("room.id"));

	DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(RoomReservation.class, "rr");
	
	reserveSubquery2.add(Restrictions.not(Restrictions.or(Restrictions.lt("to", check_in), Restrictions.gt("from", check_out))));
	//reserveSubquery.add(Restrictions.or(lhs, rhs));
	reserveSubquery2.add(Restrictions.ne("id", reserve_id));
	reserveSubquery2.setProjection(Projections.property("room.id"));
	
	Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
	criteria.add(Subqueries.propertyNotIn("id", reserveSubquery2));
	criteria.add(Subqueries.propertyNotIn("id", reserveSubquery));
	criteria.add(Restrictions.eq("id", id));
	criteria.setProjection(Projections.rowCount());
	Integer count = (Integer) criteria.uniqueResult();
	
	return count;
}
public List getRoomHaveTranscationForReport(SearchReportDate srd) {
	
	
DetachedCriteria reserveSubquery2 = DetachedCriteria.forClass(Occupancy.class, "occ");
	
reserveSubquery2.add(Restrictions.sqlRestriction("YEAR(start) = ? ", srd.getYear(),Hibernate.INTEGER));
reserveSubquery2.add(Restrictions.sqlRestriction("MONTH(start) = ? ", srd.getMonth(),Hibernate.INTEGER));
	reserveSubquery2.setProjection(Projections.property("room.id"));
	Criteria criteria = session.getCurrentSession().createCriteria(Room.class,"r");
	criteria.addOrder(Order.asc("room_no"));
	criteria.add(Subqueries.propertyIn("id", reserveSubquery2));
	
	
	
	
	return criteria.list();
	
	
}




}
