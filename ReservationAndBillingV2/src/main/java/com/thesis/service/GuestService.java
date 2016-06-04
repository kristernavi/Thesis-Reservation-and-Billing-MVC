package com.thesis.service;

import java.util.List;

import com.thesis.model.Guest;

public interface GuestService {
	public void saveGuest(Guest guest);
	public void delete(long guestId);
	public Guest getGuest(long guestId);
	public List<Guest>getAllGuest();

}
