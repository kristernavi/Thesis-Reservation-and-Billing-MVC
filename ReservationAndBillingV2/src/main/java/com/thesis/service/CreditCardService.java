package com.thesis.service;

import java.util.List;

import com.api.model.CreditCard;

public interface CreditCardService {
	public void save(CreditCard creditCard);
	public void delete(long id);
	public CreditCard getCreditCard(long id);
	public  List getAllCreditCard();

}
