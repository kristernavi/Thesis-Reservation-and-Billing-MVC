package com.thesis.dao;

import java.util.List;

import com.api.model.CreditCard;

public interface CreditCardDao {
	public void save(CreditCard creditCard);
	public void delete(long id);
	public CreditCard getCreditCard(long id);
	public CreditCard getByNumberCreditCard(long number);
	public  List getAllCreditCard();


}
