	package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.model.CreditCard;
import com.thesis.dao.CreditCardDao;
import com.thesis.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardDao ccDao;
	@Override
	@Transactional(value = "transactionManager2")
	public void save(CreditCard creditCard) {

		ccDao.save(creditCard);
	}

	@Override
	@Transactional(value = "transactionManager2")
	public void delete(long id) {

		ccDao.delete(id);
	}

	@Override
	@Transactional(readOnly=true,value = "transactionManager2")
	public CreditCard getCreditCard(long id) {
		return ccDao.getCreditCard(id);
	}

	@Override
	@Transactional(readOnly=true,value = "transactionManager2")
	public List getAllCreditCard() {

		return ccDao.getAllCreditCard();
	}

}
