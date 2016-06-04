package com.thesis.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.OccupancyDao;
import com.thesis.dao.RoomDao;
import com.thesis.model.NationalityReport;
import com.thesis.model.Occupancy;
import com.thesis.model.OccupancyReport;
import com.thesis.model.OccupancyReportV2;
import com.thesis.model.Room;
import com.thesis.model.SearchReportDate;
import com.thesis.service.OccupancyService;

@Service
public class OccupancyServiceImp implements OccupancyService {

	@Autowired
	private OccupancyDao occService;
	@Autowired
	private RoomDao roomDao;
	@Override
	@Transactional
	public void save(Occupancy occ) {

		occService.save(occ);
	}

	@Override
	@Transactional
	public void delete(long id) {

		occService.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Occupancy getOccupancy(long id) {

		return occService.getOccupancy(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllOccupancy() {

		return occService.getAllOccupancy();
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllAllowToCheckOut() {
		return occService.getAllAllowToCheckOut();
	}

	@Override
	@Transactional()
	public List getAllCheckIn() {
		
		for(Occupancy occ: occService.exceed1hr())
		{
			occ.setPayable(occ.getPayable().add(occ.getRoom().getRate()));
			Calendar now = Calendar.getInstance();
	        now.set(Calendar.HOUR, 0);
	        now.set(Calendar.MINUTE, 0);
	        now.set(Calendar.SECOND, 0);
			Date today = now.getTime();
			Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
			tomorrow.setHours(12);
			occ.setTo(tomorrow);
			occService.save(occ);
		}
		
		return occService.getAllCheckIn();
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllHaveBalance() {
		// TODO Auto-generated method stub
		return occService.getAllHaveBalance();
	}

	@Transactional(readOnly=true)
	public List<NationalityReport> getNationalityReport(SearchReportDate srd) {
		// TODO Auto-generated method stub
		return occService.getNationalityReport(srd);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OccupancyReportV2> getOccpancyReport(SearchReportDate srd) {
		// TODO Auto-generated method stub
		List<OccupancyReportV2> ocV2 = new ArrayList<OccupancyReportV2>();
		List<Room> roomList = roomDao.getRoomHaveTranscationForReport(srd);
		for(Room rm: roomList)
		{
			OccupancyReportV2 ov2 = new OccupancyReportV2();
			ov2.setListOccReport(occService.getOccpancyReport(srd,rm.getRoom_no()));
			ov2.setDate(new Date());
			ocV2.add(ov2);
			System.out.println(rm.getRoom_no());
		}
		
		return ocV2;
	}
	

}
