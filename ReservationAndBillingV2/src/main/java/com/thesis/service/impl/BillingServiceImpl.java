package com.thesis.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.BillingDao;
import com.thesis.dao.OccupancyDao;
import com.thesis.model.Billing;
import com.thesis.model.BillingCollection;
import com.thesis.model.CalculateBilling;
import com.thesis.model.Occupancy;
import com.thesis.model.SearchReportDate;
import com.thesis.service.BillingService;
@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingDao billingService;
	@Autowired
	private OccupancyDao occDao;
	
	
	@Override
	@Transactional
	public void saveBilling(Billing billing) {
		// TODO Auto-generated method stub
		billingService.saveBilling(billing);

		
	}

	@Override
	@Transactional
	public void delete(long billingId) {

		billingService.delete(billingId);
	}

	@Override
	@Transactional(readOnly=true)
	public Billing getBilling(long billingId) {

		return billingService.getBilling(billingId);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllBilling() {

		return billingService.getAllBilling();
	}

	@Override
	@Transactional(readOnly=true)
	public List getCalculateBalance() {
		List <CalculateBilling> ccBiling = new ArrayList <CalculateBilling>();
		for(Occupancy oc: occDao.getAllHaveBalance()){
			CalculateBilling cb = new CalculateBilling();
			BigDecimal amount = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			BigDecimal balance = new BigDecimal(0);
			cb.setId_recive(oc.getId());
			for(Billing bill: billingService.getBillingByIdRecieveOccupancy(oc.getId())){
				total = total.add(bill.getAmount());
			}
			amount = oc.getPayable().add(total);
			balance = amount.subtract(total);
			cb.setRoom_no(oc.getRoom().getRoom_no());
			cb.setAmount_paid(total);
			cb.setCurrent_balance(balance);
			cb.setTotal_bill(amount);
			cb.setFullname(oc.getGuest().getFullname());
			
			ccBiling.add(cb);
		}
		
		return ccBiling;
	}

	@Override
	@Transactional(readOnly=true)
	public List<BillingCollection> getCollection(SearchReportDate srd) {
		// TODO Auto-generated method stub
		return billingService.getCollection(srd);
	}

}
