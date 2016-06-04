package com.thesis.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.RoomDao;
import com.thesis.model.Room;
import com.thesis.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;

	@Override
	@Transactional
	public void saveRoom(Room room) {
		roomDao.addRoom(room);

	}

	@Override
	@Transactional()
	public void deleteRoom(long room_no) {
		roomDao.deleteRoom(room_no);

	}

	@Override
	@Transactional
	public Room getRoom(long room_no) {
		
		return roomDao.getRoom(room_no);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Room> getAllRoom() {
		
		List <Room> roomList = new ArrayList<Room>();
		for(Room r1: roomDao.getAllRoom())
		{
			for(Room r2: roomDao.getRoomHaveTranscation())
			{
				if(r1.getId()==r2.getId())
				{
				r1.setDeletable(true);
				}
				
			}
			roomList.add(r1);
			
			
		}
		
		return roomList;
	}

	@Override
	@Transactional(readOnly=true)
	public List getAvailableRoom(Date check_in, Date check_out) {
		
		return roomDao.getAvailableRoom(check_in, check_out);
	}

	@Override
	@Transactional(readOnly=true)
	public List getRoomHaveTranscation() {
		// TODO Auto-generated method stub
		return roomDao.getRoomHaveTranscation();
	}

	@Transactional(readOnly=true)
	public List getAvailableEditRoom(Date from, Date to, long id,BigDecimal rate) {
		// TODO Auto-generated method stub
		return roomDao.getAvailableEditRoom(from, to, id,rate);
	}

	@Override
	@Transactional(readOnly=true)
	public int checkIfAvailableEdit(Date check_in, Date check_out, long id, long reserve_id) {
		return roomDao.checkIfAvailableEdit(check_in, check_out, id, reserve_id);
	}
	

}
