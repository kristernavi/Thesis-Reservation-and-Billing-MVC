package com.thesis.dao;

import java.math.BigDecimal;

import com.api.model.CreditCard;
import com.thesis.model.Billing;

public class CreditCardAndBilling {

	private CreditCard cc;
	private Billing billing;
	private BigDecimal amount_pay;
	
	public CreditCardAndBilling(){}

	public CreditCardAndBilling(CreditCard cc, Billing billing,BigDecimal amount_pay) {
		super();
		this.cc = cc;
		this.billing = billing;
		this.amount_pay = amount_pay;
	}

	public CreditCard getCc() {
		return cc;
	}

	public void setCc(CreditCard cc) {
		this.cc = cc;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public BigDecimal getAmount_pay() {
		return amount_pay;
	}

	public void setAmount_pay(BigDecimal amount_pay) {
		this.amount_pay = amount_pay;
	}
	
	
}
