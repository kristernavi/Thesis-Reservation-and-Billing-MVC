package com.thesis.model;

public class RoomReservationAndOccupancy {
	
	private RoomReservation rr;
	private Occupancy occ;
	
	public RoomReservationAndOccupancy(){}
	
	
	public RoomReservationAndOccupancy(RoomReservation rr, Occupancy occ) {
		super();
		this.rr = rr;
		this.occ = occ;
	}


	public RoomReservation getRr() {
		return rr;
	}
	public void setRr(RoomReservation rr) {
		this.rr = rr;
	}
	public Occupancy getOcc() {
		return occ;
	}
	public void setOcc(Occupancy occ) {
		this.occ = occ;
	}
	
	

}
