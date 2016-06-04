package com.thesis.dao;

import java.util.Date;
import java.util.List;

import com.thesis.model.RoomReservation;

public interface RoomReservationDao {

	public void save(RoomReservation reservation);
	public void delete(long id);
	public RoomReservation getRoomReservation(long id);
	public List getAllRoomReservation();
	public List getAllActiveReservation();
	public List getReserveRoom(long id);
	public void deleteRr(long id);
	public void changeDate(Date from, Date to, long reserve_id);

}
