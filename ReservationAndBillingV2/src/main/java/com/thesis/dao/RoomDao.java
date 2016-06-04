package com.thesis.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.thesis.model.Room;
import com.thesis.model.SearchReportDate;

public interface RoomDao {
	
	public void addRoom(Room room);
	public void editRoom(Room room);
	public void deleteRoom(long room_no);
	public Room getRoom(long room_no);
	public List <Room> getAllRoom();
	public List getAvailableRoom(Date check_in, Date check_out);
	public List <Room> getRoomHaveTranscation();
	public int checkIfAvailable(Date check_in, Date check_out, long id);
	public List getAvailableEditRoom(Date from, Date to,long id,BigDecimal rate);
	public int checkIfAvailableEdit(Date check_in, Date check_out, long id,long reserve_id);
	public List<Room> getRoomHaveTranscationForReport(SearchReportDate srd);

}
