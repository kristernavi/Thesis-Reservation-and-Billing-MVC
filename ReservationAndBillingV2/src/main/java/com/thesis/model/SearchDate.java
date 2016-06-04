package com.thesis.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class SearchDate {
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_in;
	@DateTimeFormat(iso=ISO.DATE)
	private Date check_out;
	public SearchDate(Date check_in, Date check_out) {
		super();
		this.check_in = check_in;
		this.check_out = check_out;
	}
	 public SearchDate(){}
	
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
		this.check_in.setHours(12);
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
		this.check_out.setHours(12);
	}
	
	
	public String getFormatedCheck_in(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(check_in);
		return ymd;
			
	}
	public String getFormatedCheck_out(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = dmyFormat.format(check_out);
		return ymd;
			
	}
	public String getFormatedCheck_in2(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("MM/dd/yyyy");
		String ymd = dmyFormat.format(check_in);
		return ymd;
			
	}
	public String getFormatedCheck_out2(){
		SimpleDateFormat dmyFormat = new SimpleDateFormat("MM/dd/yyyy");
		String ymd = dmyFormat.format(check_out);
		return ymd;
			
	}
	
	

}
