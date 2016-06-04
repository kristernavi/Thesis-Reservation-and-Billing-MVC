package com.thesis.model;

import java.util.Date;

public class NationalityReport {
	
	private String country;
	private long number;
	private Date date;
	
	
	public NationalityReport(){}
	
	
	public NationalityReport(String country, long number) {
		super();
		this.country = country;
		this.number = number;
	}

	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	

}
