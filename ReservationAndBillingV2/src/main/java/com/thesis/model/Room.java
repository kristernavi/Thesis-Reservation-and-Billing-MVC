package com.thesis.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true,
selectBeforeUpdate = true)
public class Room {
	
	@Id
	@Column(name="room_id")
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private long id;
	@Column(unique=true)
	@NotEmpty()
	private long room_no;
	private String description;
	@NotEmpty()
	private BigDecimal rate;
	private int capacity;
	@Enumerated(value=EnumType.STRING)
	private RoomStatus status;
	
	@Enumerated(value=EnumType.STRING)
	private RoomType type;
	
	@Transient
	private boolean isDeletable;
	
	public Room(){}
	
	public Room(long id, long room_no, String description, BigDecimal rate, int capacity, RoomStatus status, RoomType type) {
		super();
		this.id = id;
		this.room_no = room_no;
		this.description = description;
		this.rate = rate;
		this.capacity = capacity;
		this.status = status;
		this.type = type;
	}


	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoom_no() {
		return room_no;
	}

	public void setRoom_no(long room_no) {
		this.room_no = room_no;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public boolean getIsDeletable() {
		return isDeletable;
	}

	public void setDeletable(boolean isDeletable) {
		this.isDeletable = isDeletable;
	}
	public String getRoomWithPrefix(){
		return "Room Number "+room_no;
	}
	
	public String getRoomWithPrefix2(){
		return "Room "+room_no;
	}
	
	
	
	

}
