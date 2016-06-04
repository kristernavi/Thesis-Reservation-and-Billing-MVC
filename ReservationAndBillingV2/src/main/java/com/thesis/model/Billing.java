package com.thesis.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@org.hibernate.annotations.Entity( dynamicUpdate = true,
selectBeforeUpdate = true)
public class Billing {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="billing_id")
	private long id;
	private long id_recieve;
	private String id_came;
	@Enumerated(value=EnumType.STRING)
	private BillingMethod method;
	private BigDecimal amount;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	public Billing(){}
	
	
	public Billing(long id, long id_recieve, String id_came, BillingMethod method, BigDecimal amount, Date date) {
		super();
		this.id = id;
		this.id_recieve = id_recieve;
		this.id_came = id_came;
		this.method = method;
		this.amount = amount;
		this.date = date;
	}




	public long getId_recieve() {
		return id_recieve;
	}




	public void setId_recieve(long id_recieve) {
		this.id_recieve = id_recieve;
	}




	public String getId_came() {
		return id_came;
	}




	public void setId_came(String id_came) {
		this.id_came = id_came;
	}




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public BillingMethod getMethod() {
		return method;
	}
	public void setMethod(BillingMethod method) {
		this.method = method;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	

}
