package com.thesis.model;

import java.math.BigDecimal;
import java.util.Date;

public class EditReservation {
	
	private long reserve_id;
	private Date editFrom;
	private Date editTo;
	private BigDecimal newPayable;
	private long cc_number;
	private long param_id;
	private String key;
	private BillingMethod method;
	
	public EditReservation(){}

	public EditReservation(long reserve_id, Date editFrom, Date editTo, BigDecimal newPayable) {
		super();
		this.reserve_id = reserve_id;
		this.editFrom = editFrom;
		this.editTo = editTo;
		this.newPayable = newPayable;
	}
	
	
	
	

	public BillingMethod getMethod() {
		return method;
	}

	public void setMethod(BillingMethod method) {
		this.method = method;
	}

	public long getParam_id() {
		return param_id;
	}

	public void setParam_id(long param_id) {
		this.param_id = param_id;
	}

	public long getReserve_id() {
		return reserve_id;
	}

	public void setReserve_id(long reserve_id) {
		this.reserve_id = reserve_id;
	}

	public Date getEditFrom() {
		return editFrom;
	}

	public void setEditFrom(Date editFrom) {
		this.editFrom = editFrom;
	}

	public Date getEditTo() {
		return editTo;
	}

	public void setEditTo(Date editTo) {
		this.editTo = editTo;
	}

	public BigDecimal getNewPayable() {
		return newPayable;
	}

	public void setNewPayable(BigDecimal newPayable) {
		this.newPayable = newPayable;
	}

	public long getCc_number() {
		return cc_number;
	}

	public void setCc_number(long cc_number) {
		this.cc_number = cc_number;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
