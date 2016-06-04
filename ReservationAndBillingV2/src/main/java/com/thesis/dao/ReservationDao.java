package com.thesis.dao;

import java.util.List;

import com.thesis.model.Reservation;

public interface ReservationDao {
	
	public void save(Reservation reservation);
	public void delete(long id);
	public Reservation getReservation(long id);
	public List getAllReservation();
	public Reservation getReservationByReference(String key);

}
