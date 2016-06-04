package com.thesis.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true,
selectBeforeUpdate = true)
public class AddOn {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="addOn_id")
	private long id;
	private String description;
	private BigDecimal rate;
	
	
	public AddOn(){}
	public AddOn(long id, String description, BigDecimal rate) {
		super();
		this.id = id;
		this.description = description;
		this.rate = rate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	

}
