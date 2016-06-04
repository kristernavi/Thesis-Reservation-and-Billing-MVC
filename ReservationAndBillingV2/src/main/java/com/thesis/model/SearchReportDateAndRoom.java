package com.thesis.model;

public class SearchReportDateAndRoom {
	
	private int month;
	private int year;
	private long id;
	
	public SearchReportDateAndRoom(){
		
	}
	
	

	public SearchReportDateAndRoom(int month, int year) {
		super();
		this.month = month;
		this.year = year;
	}


	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

}
