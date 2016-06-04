package com.thesis.service;

import java.util.List;

import com.thesis.model.Billing;
import com.thesis.model.BillingCollection;
import com.thesis.model.SearchReportDate;

public interface BillingService {
	public void saveBilling(Billing billing);
	public void delete(long billingId);
	public Billing getBilling(long billingId);
	public List getAllBilling();
	public List getCalculateBalance();
	public List <BillingCollection>getCollection(SearchReportDate srd);

}
