package com.thesis.model;

import java.util.Date;
import java.util.List;

public class OccupancyReportV2 {
	
	private List <OccupancyReport> listOccReport;
	private Date date;
	
	
	public OccupancyReportV2(){}


	public List<OccupancyReport> getListOccReport() {
		return listOccReport;
	}


	public void setListOccReport(List<OccupancyReport> listOccReport) {
		this.listOccReport = listOccReport;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	
	

}
