package com.thesis.service;

import java.util.List;

import com.thesis.model.RoomReservation;

public interface RoomReservationService {

	public void save(RoomReservation reservation);
	public void delete(long id);
	public RoomReservation getRoomReservation(long id);
	public List getAllRoomReservation();
	public List getAllActiveReservation();
	public List getReserveRoom(long id);
	public void deleteRr(long id);
}
