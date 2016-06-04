package com.thesis.dao;

import java.util.List;

import com.thesis.model.Guest;

public interface GuestDao {
	public void saveGuest(Guest guest);
	public void edit(Guest guest);
	public void delete(long guestId);
	public Guest getGuest(long guestId);
	public List<Guest>getAllGuest();

}
