package com.thesis.model;

public enum RoomType {
	DORMITORY("DORMITORY"),EXECUTIVE("EXECUTIVE"), AMBASSADOR("AMBASSADOR"), 
	DELUXE_A("DELUXE A"), DELUXE_B ("DELUXE B"),STANDARD("STANDARD");
	
	private String name;

	

	private RoomType(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public String toString() {
	    return name;
	}
	

}
