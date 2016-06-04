package com.thesis.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RoomReservation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rr_id")
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start")
	private Date from;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end")
	private Date to;
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
	@ManyToOne()
	@JoinColumn(name="reserve_id")
	private Reservation reserve;
	
	public RoomReservation(){}


	public RoomReservation(long id, Reservation reserve, Date from, Date to, Room room) {
		super();
		this.id = id;
		this.reserve = reserve;
		this.from = from;
		this.to = to;
		this.room = room;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
		
	}


	public Reservation getReserve() {
		return reserve;
	}


	public void setReserve(Reservation reserve) {
		this.reserve = reserve;
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


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	public String getFormatedCheck_in2(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("MM/dd/yyyy");
		String ymd = dmyFormat.format(from);
		return ymd;
			
	}
	public String getFormatedCheck_out2(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("MM/dd/yyyy");
		String ymd = dmyFormat.format(to);
		return ymd;
			
	}
	public String getFormatedCheck_in(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(from);
		return ymd;
			
	}
	public String getFormatedCheck_out(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(to);
		return ymd;
			
	}
	
	

}
