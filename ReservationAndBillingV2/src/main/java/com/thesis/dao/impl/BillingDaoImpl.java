package com.thesis.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.BillingDao;
import com.thesis.model.Billing;
import com.thesis.model.BillingCollection;
import com.thesis.model.SearchReportDate;
@Repository
public class BillingDaoImpl implements BillingDao {

	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	@Override
	public void saveBilling(Billing billing) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(billing);

	}

	@Override
	public void delete(long billingId) {

		session.getCurrentSession().delete(this.getBilling(billingId));
	}

	@Override
	public Billing getBilling(long billingId) {

		return (Billing) session.getCurrentSession().get(Billing.class, billingId);
	}

	@Override
	public List getAllBilling() {

		return session.getCurrentSession().createQuery("from Billing").list();
	}
	
	public List getBillingByIdRecieveOccupancy(long id){
		return session.getCurrentSession().createQuery("from Billing as bill where bill.id_recieve"
				+ " = "+id+" and bill.id_came = 'O' ").list();
	}
	
	public List <BillingCollection>getCollection(SearchReportDate srd) {
List result = session.getCurrentSession().createQuery("SELECT p.date, sum( case when p.method='CASH' then p.amount else 0 end ) as april, sum( case when p.method='CREDIT_CARD' then p.amount else 0 end ) as may from Billing p where month(p.date)="+srd.getMonth()+" and year(p.date)="+srd.getYear()+" GROUP BY p.date").list();
	List <BillingCollection> bcFull = new ArrayList <BillingCollection>();
		for (Iterator it = result.iterator(); it.hasNext(); ) {
		    Object[] myResult = (Object[]) it.next();
		    BillingCollection bc = new BillingCollection();
		  System.out.println(myResult[0]);
		  System.out.println(myResult[1]);
		  System.out.println(myResult[2]);
		  bc.setDate((Date)myResult[0]);
		  bc.setAmountOfCash((BigDecimal)myResult[1]);
		  bc.setAmountOfCredit_Card((BigDecimal)myResult[2]);
		  bcFull.add(bc);
		}
		return bcFull;
	}

}
