package com.thesis.service;

import com.thesis.model.CreditCardBillingReservation;

public interface ProccessBillingService {
	public String methodCreditCardSave(CreditCardBillingReservation ccBr);
	public void methodCashSave(CreditCardBillingReservation ccBr);

}
