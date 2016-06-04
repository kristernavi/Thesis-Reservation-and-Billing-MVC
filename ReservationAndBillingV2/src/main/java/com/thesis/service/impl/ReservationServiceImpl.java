package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.ReservationDao;
import com.thesis.model.Reservation;
import com.thesis.service.ReservationService;
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	@Override
	@Transactional
	public void save(Reservation reservation) {

		reservationDao.save(reservation);
		
	}

	@Override
	@Transactional
	public void delete(long id) {

		reservationDao.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Reservation getReservation(long id) {

		return reservationDao.getReservation(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllReservation() {

		return reservationDao.getAllReservation();
	}

	@Override
	@Transactional(readOnly=true)
	public Reservation getReservationByReference(String key) {
		// TODO Auto-generated method stub
		return reservationDao.getReservationByReference(key);
	}

}
