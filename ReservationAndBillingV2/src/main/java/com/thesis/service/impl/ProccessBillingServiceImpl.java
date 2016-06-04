package com.thesis.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.model.CreditCard;
import com.thesis.dao.BillingDao;
import com.thesis.dao.CreditCardDao;
import com.thesis.dao.OccupancyDao;
import com.thesis.model.CreditCardBillingReservation;
import com.thesis.model.Occupancy;
import com.thesis.service.ProccessBillingService;
@Service
public class ProccessBillingServiceImpl implements ProccessBillingService{
	
	@Autowired
	private CreditCardDao ccDao;
	@Autowired
	private OccupancyDao occDao;
	@Autowired
	private BillingDao billingDao;
	@Transactional
	public String methodCreditCardSave(CreditCardBillingReservation ccBr){
		CreditCard cc = ccDao.getByNumberCreditCard(ccBr.getCc().getNumber());
		String result = null;
		if(cc!=null)
		{
			if(cc.getBalance().compareTo(ccBr.getAmount_pay())>=0)
			{
				Occupancy occ = occDao.getOccupancy(ccBr.getBilling().getId_recieve());
				occ.setPayable(new BigDecimal(0));
				occDao.save(occ);
				billingDao.saveBilling(ccBr.getBilling());
				cc.setBalance(cc.getBalance().subtract(ccBr.getAmount_pay()));
				ccDao.save(cc);
				return "success";
			}
			
			else
				
				return "insuficient";
		}
		else
			return "notfound";
		
	}
	@Transactional
	public void methodCashSave(CreditCardBillingReservation ccBr){
		Occupancy occ = occDao.getOccupancy(ccBr.getBilling().getId_recieve());
		occ.setPayable(new BigDecimal(0));
		occDao.save(occ);
		billingDao.saveBilling(ccBr.getBilling());
		
	}

}
