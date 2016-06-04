package com.thesis.dao;

import java.util.List;

import com.thesis.model.NationalityReport;
import com.thesis.model.Occupancy;
import com.thesis.model.OccupancyReport;
import com.thesis.model.SearchReportDate;
import com.thesis.model.SearchReportDateAndRoom;

public interface OccupancyDao {
	
	public void save(Occupancy occ);
	public void delete(long id);
	public Occupancy getOccupancy(long id);
	public List getAllOccupancy();
	public List getAllAllowToCheckOut();
	public List getAllCheckIn();
	public List <Occupancy> getAllHaveBalance();
	public List<NationalityReport> getNationalityReport(SearchReportDate srd);
	public List <OccupancyReport> getOccpancyReport(SearchReportDate srd, long id);
	public List <Occupancy> exceed1hr();
}
