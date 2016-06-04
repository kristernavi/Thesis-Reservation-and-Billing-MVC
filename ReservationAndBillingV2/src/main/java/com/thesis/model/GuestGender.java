package com.thesis.model;

public enum GuestGender {
	M("MALE"),F("FEMALE");
	
	String name;

	
	private GuestGender(String name) {
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
