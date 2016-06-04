package com.thesis.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.model.CreditCard;
import com.thesis.dao.BillingDao;
import com.thesis.dao.CreditCardDao;
import com.thesis.dao.OccupancyDao;
import com.thesis.dao.RoomDao;
import com.thesis.model.Billing;
import com.thesis.model.BillingMethod;
import com.thesis.model.PreOccupancy;
import com.thesis.service.ProccessOccupancyService;

@Service
public class ProccessOccupancyImpl implements ProccessOccupancyService {
	
	@Autowired
	private CreditCardDao ccDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private OccupancyDao occDao;
	@Autowired
	private BillingDao billingDao;

	@Override
	@Transactional
	public String methodCreditCard(PreOccupancy preOcc) {
		CreditCard cc = ccDao.getByNumberCreditCard(preOcc.getCc().getNumber());
		
		if(cc!=null)
		{
			if(cc.getBalance().compareTo(preOcc.getPayable())>=0){
				if(roomDao.checkIfAvailable(preOcc.getCheck_in(), preOcc.getCheck_out(), preOcc.getRoom_id())==1)
				{
					preOcc.getOcc().setPayable(new BigDecimal(0));
					occDao.save(preOcc.getOcc());
					cc.setBalance(cc.getBalance().subtract(preOcc.getPayable()));
					ccDao.save(cc);
					Billing billing = new Billing();
					billing.setAmount(preOcc.getPayable());
					billing.setDate(new Date());
					billing.setId_recieve(preOcc.getOcc().getId());
					billing.setId_came("O");
					billing.setMethod(BillingMethod.CREDIT_CARD);
					billingDao.saveBilling(billing);
					return "success";
				}
				else
				{
					return "conflict";
				}
			}
			else
			{
				return "insuficient";
			}
		}
		else
		{
			return "notfound";
		}
	}

	@Override
	@Transactional
	public String methodCashSave(PreOccupancy preOcc) {
		
		if(roomDao.checkIfAvailable(preOcc.getCheck_in(), preOcc.getCheck_out(), preOcc.getRoom_id())==1)
		{
			preOcc.getOcc().setPayable(new BigDecimal(0));
			occDao.save(preOcc.getOcc());
			Billing billing = new Billing();
			billing.setAmount(preOcc.getPayable());
			billing.setDate(new Date());
			billing.setId_recieve(preOcc.getOcc().getId());
			billing.setId_came("O");
			billing.setMethod(BillingMethod.CASH);
			billingDao.saveBilling(billing);
			return "success";
		}
		else
			return "conflict";
		
	}

}
