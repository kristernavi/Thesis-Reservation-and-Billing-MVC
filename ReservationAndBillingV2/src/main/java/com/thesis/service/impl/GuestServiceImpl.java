package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.GuestDao;
import com.thesis.model.Guest;
import com.thesis.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestDao guestDao;
	@Override
	@Transactional
	public void saveGuest(Guest guest) {
		guestDao.saveGuest(guest);

	}

	

	@Override
	@Transactional
	public void delete(long guestId) {
		guestDao.delete(guestId);

	}

	@Override
	@Transactional
	public Guest getGuest(long guestId) {
		
		return guestDao.getGuest(guestId);
	}

	@Override
	@Transactional
	public List<Guest> getAllGuest() {
		
		return guestDao.getAllGuest();
	}

}
