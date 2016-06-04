package com.thesis.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.api.model.CreditCard;

public class PreOccupancy {
	
	private Occupancy occ; 
	private Billing billing;
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_in;
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_out;
	private BigDecimal payable;
	private long room_id;
	private Room room;
	private CreditCard cc;
	
	
	public PreOccupancy(){}


	public PreOccupancy(Occupancy occ, Billing billing, Date check_in, Date check_out, BigDecimal payable,
			CreditCard cc) {
		super();
		this.occ = occ;
		this.billing = billing;
		this.check_in = check_in;
		this.check_out = check_out;
		this.payable = payable;
		this.cc = cc;
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


	public Occupancy getOcc() {
		return occ;
	}


	public void setOcc(Occupancy occ) {
		this.occ = occ;
	}


	public Billing getBilling() {
		return billing;
	}


	public void setBilling(Billing billing) {
		this.billing = billing;
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


	public BigDecimal getPayable() {
		return payable;
	}


	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}


	public CreditCard getCc() {
		return cc;
	}


	public void setCc(CreditCard cc) {
		this.cc = cc;
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
	public BigDecimal getTotalFee(){
		return this.getRoom().getRate().multiply(new BigDecimal(this.getNumberOfDays()));
	}

	
	
	

}
