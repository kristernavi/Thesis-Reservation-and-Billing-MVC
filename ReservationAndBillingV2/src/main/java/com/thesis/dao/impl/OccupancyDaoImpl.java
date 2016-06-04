package com.thesis.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.thesis.dao.OccupancyDao;
import com.thesis.model.DateListC;
import com.thesis.model.NationalityReport;
import com.thesis.model.Occupancy;
import com.thesis.model.OccupancyReport;
import com.thesis.model.Room;
import com.thesis.model.SearchReportDate;
import com.thesis.model.SearchReportDateAndRoom;
@Repository
public class OccupancyDaoImpl implements OccupancyDao {

	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory session;
	@Override
	public void save(Occupancy occ) {

		session.getCurrentSession().merge(occ);
	}

	@Override
	public void delete(long id) {

		session.getCurrentSession().delete(this.getOccupancy(id));
	}

	@Override
	public Occupancy getOccupancy(long id) {

		return (Occupancy) session.getCurrentSession().get(Occupancy.class, id);
	}

	@Override
	public List getAllOccupancy() {
		
		return session.getCurrentSession().createQuery("from Occupancy").list();
	}

	@Override
	public List getAllAllowToCheckOut() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Occupancy as occ where occ.status = 'CHECK_IN' and occ.payable = 0 order by occ.from , occ.to").list();
	}
	
	public List getAllCheckIn(){
		return session.getCurrentSession().createQuery("from Occupancy as occ where occ.status = 'CHECK_IN'").list();
	}
	public List getAllHaveBalance(){
		return session.getCurrentSession().createQuery("from Occupancy as occ where occ.status = 'CHECK_IN' and occ.payable > 0 order by occ.from , occ.to").list();
	}

	@Override
	public List<NationalityReport> getNationalityReport(SearchReportDate srd) {
		// TODO Auto-generated method stub
		List<NationalityReport>nrList = new ArrayList<NationalityReport>();
		List result = session.getCurrentSession().createQuery("select count(*), occ.guest.nationality, occ.from from Occupancy as occ where (month(occ.from)="+srd.getMonth()+" and year(occ.from)="+srd.getYear()+")  or (month(occ.to)="+srd.getMonth()+" and year(occ.to)="+srd.getYear()+") group by occ.guest.nationality order by count(*) desc").list();
		
		for (Iterator it = result.iterator(); it.hasNext(); ) {
			
			Object[] myResult = (Object[]) it.next();
		    System.out.println(myResult[0]);
			  System.out.println(myResult[1]);
			  NationalityReport  nr = new NationalityReport();
			  Locale obj = new Locale("", (String)myResult[1]);
			  nr.setCountry(obj.getDisplayCountry());
			  nr.setNumber((long)myResult[0]);
			  nr.setDate((Date)myResult[2]);
			  nrList.add(nr);
		    
		}
		
		return nrList;
	}

	@Override
	public List<OccupancyReport> getOccpancyReport(SearchReportDate srd, long id) {
		
		
		List<OccupancyReport> occReport = new ArrayList<OccupancyReport>();	
		List result = session.getCurrentSession().createQuery("select occ.room.room_no, occ.from,occ.to from Occupancy as occ where occ.room.room_no = "+id+" and (month(occ.from)="+srd.getMonth()+" and year(occ.from)="+srd.getYear()+") ").list();
		List<OccupancyReport> occReport2 = new ArrayList<OccupancyReport>();
		for (Iterator it = result.iterator(); it.hasNext(); ) {
			
		    Object[] myResult = (Object[]) it.next();
		    System.out.println(myResult[0]);
			  System.out.println(myResult[1]);
			  
			 
			  Date startdate = (Date)myResult[1];
			  Date enddate2 = (Date)myResult[2];
			  Date now = new Date();
			  Date enddate;
			  if(enddate2.compareTo(now) == 1)
			  {
				  enddate = enddate2;
			  }
			  else
			  {
				  enddate = enddate2;
			  }
			  	List<DateListC> dateList = new ArrayList<DateListC>();
			  	List<DateListC> dateList2 = new ArrayList<DateListC>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startdate);
			    OccupancyReport orep = new OccupancyReport();
			    orep.setRoom_no((long)myResult[0]);
			    while (calendar.getTime().before(enddate))
			    {
			    	
			    	DateListC cDate = new DateListC();
			        Date res = calendar.getTime();
			        cDate.setDateRetrive(res);
			        dateList.add(cDate);
			        calendar.add(Calendar.DATE, 1);
			    }
			    
			    orep.setDateList(dateList);
			    
			 occReport.add(orep);
			 int total = 0;
			 for(OccupancyReport or: occReport)
			 {
				 total+=or.getDateList().size();
			 }
			 orep.setTotal_room(total);
		}
		OccupancyReport report2 = occReport.get(0);
		List<DateListC> cdate= new ArrayList<DateListC>();
		
		for(OccupancyReport oc2: occReport)
		{
			for(DateListC cd2: oc2.getDateList())
			{
				cdate.add(cd2);
			}
		}
		report2.setDateList(cdate);
		report2.setTotal_room(report2.getDateList().size());
		occReport2.add(report2);
		
		return occReport2;
	}

	@Override
	public List<Occupancy> exceed1hr() {
		
		Date d = Timestamp.valueOf( LocalDateTime.now().minusHours(1));
		Criteria criteria = session.getCurrentSession().createCriteria(Occupancy.class,"occ");
		criteria.add(Restrictions.eq("status", "CHECK_IN" ));
		criteria.add(Restrictions.le("to",d  ));
		return criteria.list();
	}
	
	

}
