package com.thesis.model;

import java.math.BigDecimal;
import java.util.Date;

public class BillingCollection {

	private Date date;
	private BigDecimal amountOfCash = new BigDecimal(0);
	private BigDecimal amountOfCredit_Card= new BigDecimal(0);
	
	public BillingCollection(){
		
	}
	

	public BillingCollection(Date date, BigDecimal amountOfCash, BigDecimal amountOfCredit_Card) {
		super();
		this.date = date;
		this.amountOfCash = amountOfCash;
		this.amountOfCredit_Card = amountOfCredit_Card;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmountOfCash() {
		return amountOfCash;
	}

	public void setAmountOfCash(BigDecimal amountOfCash) {
		this.amountOfCash = amountOfCash;
	}

	public BigDecimal getAmountOfCredit_Card() {
		return amountOfCredit_Card;
	}

	public void setAmountOfCredit_Card(BigDecimal amountOfCredit_Card) {
		this.amountOfCredit_Card = amountOfCredit_Card;
	}
	
	

}
