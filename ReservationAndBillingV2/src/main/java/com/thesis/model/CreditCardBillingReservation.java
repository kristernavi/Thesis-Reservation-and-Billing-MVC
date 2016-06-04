package com.thesis.model;

import java.math.BigDecimal;

import com.api.model.CreditCard;

public class CreditCardBillingReservation {
	
	private CreditCard cc;
	private Billing billing;
	private Reservation reservation;
	private BigDecimal amount_pay;
	
	public CreditCardBillingReservation(){
		
	}
	
	
	
	public CreditCardBillingReservation(CreditCard cc, Billing billing, Reservation reservation,
			BigDecimal amount_pay) {
		super();
		this.cc = cc;
		this.billing = billing;
		this.reservation = reservation;
		this.amount_pay = amount_pay;
	}



	public CreditCard getCc() {
		return cc;
	}
	public void setCc(CreditCard cc) {
		this.cc = cc;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public BigDecimal getAmount_pay() {
		return amount_pay;
	}
	public void setAmount_pay(BigDecimal amount_pay) {
		this.amount_pay = amount_pay;
	}
	
	

}
