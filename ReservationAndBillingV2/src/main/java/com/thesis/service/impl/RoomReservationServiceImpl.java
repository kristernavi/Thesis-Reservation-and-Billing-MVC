package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.RoomReservationDao;
import com.thesis.model.RoomReservation;
import com.thesis.service.RoomReservationService;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {

	@Autowired
	private RoomReservationDao rrService;
	@Override
	@Transactional
	public void save(RoomReservation reservation) {

		rrService.save(reservation);
	}

	@Override
	@Transactional
	public void delete(long id) {

		rrService.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public RoomReservation getRoomReservation(long id) {

		return rrService.getRoomReservation(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllRoomReservation() {

		return rrService.getAllRoomReservation();
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllActiveReservation() {
		// TODO Auto-generated method stub
		return rrService.getAllActiveReservation();
	}

	@Override
	@Transactional(readOnly=true)
	public List getReserveRoom(long id) {
		// TODO Auto-generated method stub
		return rrService.getReserveRoom(id);
	}

	@Override
	@Transactional
	public void deleteRr(long id) {
		rrService.deleteRr(id);
		
	}

}
