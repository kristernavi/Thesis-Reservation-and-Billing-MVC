package com.thesis.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.thesis.model.Room;

public interface RoomService {
	public void saveRoom(Room room);
	public void deleteRoom(long room_no);
	public Room getRoom(long room_no);
	public List <Room> getAllRoom();
	public List getAvailableRoom(Date check_in, Date check_out);
	public List <Room> getRoomHaveTranscation();
	public List getAvailableEditRoom(Date from, Date to,long id,BigDecimal rate);
	public int checkIfAvailableEdit(Date check_in, Date check_out, long id,long reserve_id);

}
