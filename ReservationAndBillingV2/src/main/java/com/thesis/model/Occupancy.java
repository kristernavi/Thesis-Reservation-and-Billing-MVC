package com.thesis.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Occupancy {

	@Id
	@Column(name="occ_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne()
	@JoinColumn(name="room_id")
	private Room room;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="guest_id")
	private Guest guest;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="start")
	private Date from;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="end")
	private Date to;
	private BigDecimal payable;
	private String status;
	public Occupancy(){
		
	}

	public Occupancy(long id, Room room, Guest guest, Date from, Date to, BigDecimal payable) {
		super();
		this.id = id;
		this.room = room;
		this.guest = guest;
		this.from = from;
		this.to = to;
		this.payable = payable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
		this.from.setHours(12);
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
		this.to.setHours(12);
	}

	public BigDecimal getPayable() {
		return payable;
	}

	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
