package com.thesis.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_id")
	private long id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id")
	private Client client;
	private String reference;
	private BigDecimal payable;
	@Temporal(TemporalType.TIMESTAMP)
	private Date reserveDate;
	@OneToMany(mappedBy="reserve",cascade=CascadeType.ALL)
	private List<RoomReservation>roomReservation;
	public Reservation(){
		
	}


	public Reservation(long id, Client client, String reference, BigDecimal payable, Date reserveDate) {
		super();
		this.id = id;
		this.client = client;
		this.reference = reference;
		this.payable = payable;
		this.reserveDate = reserveDate;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public BigDecimal getPayable() {
		return payable;
	}


	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}


	public Date getReserveDate() {
		return reserveDate;
	}


	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}


	public List<RoomReservation> getRoomReservation() {
		return roomReservation;
	}


	public void setRoomReservation(List<RoomReservation> roomReservation) {
		this.roomReservation = roomReservation;
	}
	
	
	

}
