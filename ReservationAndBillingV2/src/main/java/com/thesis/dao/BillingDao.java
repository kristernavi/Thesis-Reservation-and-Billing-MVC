package com.thesis.dao;

import java.util.List;

import com.thesis.model.Billing;
import com.thesis.model.BillingCollection;
import com.thesis.model.SearchReportDate;

public interface BillingDao {
	public void saveBilling(Billing billing);
	public void delete(long billingId);
	public Billing getBilling(long billingId);
	public List getAllBilling();
	public List<Billing> getBillingByIdRecieveOccupancy(long id);
	public List <BillingCollection>getCollection(SearchReportDate srd);
	


}
