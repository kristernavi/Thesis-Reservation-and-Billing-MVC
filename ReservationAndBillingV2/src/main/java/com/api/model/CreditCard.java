package com.api.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="creditCard_id")
	private long id;
	@Column(unique=true)
	
	private long number;
	private BigDecimal balance;
	
	public CreditCard(){}

	public CreditCard(long id, long number, BigDecimal balance) {
		
		super();
		this.id = id;
		this.number = number;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	

}
