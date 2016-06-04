package com.thesis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AddOnDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AddOnDetail_id")
	private long id;
	@ManyToOne()
	@JoinColumn(name="AddOn_id", nullable=false)
	private AddOn AddOn;
	@ManyToOne()
	@JoinColumn(name="occ_id", nullable=false)
	private Occupancy occupancy;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date = new Date();
	
	
	public AddOnDetail(){}


	public AddOnDetail(long id, AddOn AddOn, Occupancy occupancy, Date date) {
		super();
		this.id = id;
		this.AddOn = AddOn;
		this.occupancy = occupancy;
		this.date = date;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public AddOn getAddOn() {
		return AddOn;
	}


	public void setAddOn(AddOn AddOn) {
		this.AddOn = AddOn;
	}


	public Occupancy getOccupancy() {
		return occupancy;
	}


	public void setOccupancy(Occupancy occupancy) {
		this.occupancy = occupancy;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
