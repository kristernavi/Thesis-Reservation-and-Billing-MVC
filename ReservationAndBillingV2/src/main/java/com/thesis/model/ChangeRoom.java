package com.thesis.model;

public class ChangeRoom {
	
	private long room_id;
	private long rr_id;
	private String key;
	
	
	public ChangeRoom(){}


	public ChangeRoom(long room_id, long rr_id) {
		super();
		this.room_id = room_id;
		this.rr_id = rr_id;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public long getRoom_id() {
		return room_id;
	}


	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}


	public long getRr_id() {
		return rr_id;
	}


	public void setRr_id(long rr_id) {
		this.rr_id = rr_id;
	}
	
	

}
