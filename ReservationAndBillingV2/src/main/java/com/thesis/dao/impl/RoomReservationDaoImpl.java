package com.thesis.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.RoomReservationDao;
import com.thesis.model.RoomReservation;
@Repository
public class RoomReservationDaoImpl implements RoomReservationDao {
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	@Override
	public void save(RoomReservation reservation) {

	
		session.getCurrentSession().merge(reservation);
	}

	@Override
	public void delete(long id) {

		session.getCurrentSession().delete(this.getRoomReservation(id));
	}

	@Override
	public RoomReservation getRoomReservation(long id) {
		return (RoomReservation) session.getCurrentSession().get(RoomReservation.class, id);
	}

	@Override
	public List getAllRoomReservation() {
		return session.getCurrentSession().createQuery("from RoomReservation as rr group by rr.reserve order by rr.from , rr.to").list();
	}
	public List getAllActiveReservation(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        String ymd = dmyFormat.format(now.getTime());
        System.out.println(dmyFormat.format(now.getTime()));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        Calendar cal = Calendar.getInstance();
	        cal.set(Calendar.HOUR, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        
	        cal.add(Calendar.DATE, -1);
	        String yesterday = dateFormat.format(cal.getTime());
		return session.getCurrentSession().createQuery("from RoomReservation as rr where rr.from >= '"+yesterday+"' and rr.from  <= '"+ymd+"'  group by rr.reserve order by rr.from , rr.to").list();
		
	}
	public List getReserveRoom(long id){
		
		return session.getCurrentSession().createQuery("from RoomReservation as rr where rr.reserve.id = "+id).list();
		
	}

	@Override
	public void deleteRr(long id) {

		session.getCurrentSession().createQuery("delete from RoomReservation where reserve.id = "+id);
	}
	
	public void changeDate(Date from, Date to, long reserve_id)
	{
		session.getCurrentSession().createQuery("update RoomReservation set from = '"+from+"' , to = '"+to+"' where reserve.id = "+reserve_id);
	}
	

}
