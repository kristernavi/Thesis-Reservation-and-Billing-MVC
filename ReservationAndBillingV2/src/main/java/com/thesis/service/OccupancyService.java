package com.thesis.service;

import java.util.List;

import com.thesis.model.NationalityReport;
import com.thesis.model.Occupancy;
import com.thesis.model.OccupancyReport;
import com.thesis.model.OccupancyReportV2;
import com.thesis.model.SearchReportDate;
import com.thesis.model.SearchReportDateAndRoom;

public interface OccupancyService {
	public void save(Occupancy occ);
	public void delete(long id);
	public Occupancy getOccupancy(long id);
	public List getAllOccupancy();
	public List getAllAllowToCheckOut();
	public List getAllCheckIn();
	public List getAllHaveBalance();
	public List<NationalityReport> getNationalityReport(SearchReportDate srd);
	public List <OccupancyReportV2> getOccpancyReport(SearchReportDate srd);



}
