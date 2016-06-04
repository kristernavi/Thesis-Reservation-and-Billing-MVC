package com.thesis.model;

import java.util.Date;
import java.util.List;

public class OccupancyReport {
	
	private long room_no;
	private long total_room;

	private List<DateListC>dateList;
	public OccupancyReport(){}

	public OccupancyReport(long room_no, Date date) {
		super();
		this.room_no = room_no;
	}
	
	

	
	public long getTotal_room() {
		return total_room;
	}

	public void setTotal_room(long total_room) {
		this.total_room = total_room;
	}

	public List<DateListC> getDateList() {
		return dateList;
	}

	public void setDateList(List<DateListC> dateList) {
		this.dateList = dateList;
	}

	public long getRoom_no() {
		return room_no;
	}

	public void setRoom_no(long room_no) {
		this.room_no = room_no;
	}

	
	

		
	
}
