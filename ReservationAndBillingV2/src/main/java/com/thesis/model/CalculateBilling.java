package com.thesis.model;

import java.math.BigDecimal;

public class CalculateBilling {
	
	private String fullname;
	private long room_no;
	private BigDecimal total_bill;
	private BigDecimal amount_paid;
	private BigDecimal current_balance;
	private long id_recive;
	
	public CalculateBilling(){}
	public CalculateBilling(String fullname, long room_no, BigDecimal total_bill, BigDecimal amount_paid,
			BigDecimal current_balance, long id_recive) {
		super();
		this.fullname = fullname;
		this.room_no = room_no;
		this.total_bill = total_bill;
		this.amount_paid = amount_paid;
		this.current_balance = current_balance;
		this.id_recive = id_recive;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public long getRoom_no() {
		return room_no;
	}
	public void setRoom_no(long room_no) {
		this.room_no = room_no;
	}
	public BigDecimal getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(BigDecimal total_bill) {
		this.total_bill = total_bill;
	}
	public BigDecimal getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(BigDecimal amount_paid) {
		this.amount_paid = amount_paid;
	}
	public BigDecimal getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(BigDecimal current_balance) {
		this.current_balance = current_balance;
	}
	public long getId_recive() {
		return id_recive;
	}
	public void setId_recive(long id_recive) {
		this.id_recive = id_recive;
	}
	
	
	

}
