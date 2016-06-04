package com.thesis.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ReservationPreLoad {
	private long room_id;
	private Room room;
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_in;
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_out;
	private CreditCardBillingReservation ccBillingReservation;
	private ArrayOfRooms ar;
	private int counter;
	private BigDecimal payable;
	public ReservationPreLoad(){}
	
	

	public ReservationPreLoad(long room_id, Room room, Date check_in, Date check_out,
			CreditCardBillingReservation ccBillingReservation) {
		super();
		this.room_id = room_id;
		this.room = room;
		this.check_in = check_in;
		this.check_out = check_out;
		this.ccBillingReservation = ccBillingReservation;
	}



	public BigDecimal getPayable() {
		return payable;
	}



	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}



	public int getCounter() {
		return counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}



	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public CreditCardBillingReservation getCcBillingReservation() {
		return ccBillingReservation;
	}

	public void setCcBillingReservation(CreditCardBillingReservation ccBillingReservation) {
		this.ccBillingReservation = ccBillingReservation;
	}



	public ArrayOfRooms getAr() {
		return ar;
	}



	public void setAr(ArrayOfRooms ar) {
		this.ar = ar;
	}
	
	public long getNumberOfDays()
	{
		long diff = Math.abs(check_out.getTime() - check_in.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}
	
	


	public String getFormatedCheck_in(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(check_in);
		return ymd;
			
	}
	public String getFormatedCheck_out(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(check_out);
		return ymd;
			
	}

	

	
}
