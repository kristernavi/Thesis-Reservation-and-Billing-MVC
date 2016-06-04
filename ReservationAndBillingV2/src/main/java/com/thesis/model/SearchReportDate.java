package com.thesis.model;

public class SearchReportDate {
	
	private int month;
	private int year;
	
	public SearchReportDate(){
		
	}
	
	

	public SearchReportDate(int month, int year) {
		super();
		this.month = month;
		this.year = year;
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
