package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.AddOnDetailDao;
import com.thesis.model.AddOnDetail;
import com.thesis.service.AddOnDetailService;
@Service
public class AddOnDetailServiceImpl implements AddOnDetailService {
	
	@Autowired
	private AddOnDetailDao addOnDetailDao;

	@Override
	@Transactional
	public void save(AddOnDetail addOnDetail) {

		addOnDetailDao.save(addOnDetail);
	}

	@Override
	@Transactional
	public void delete(long id) {

		addOnDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public AddOnDetail getAddOnDetailById(long id) {

		return addOnDetailDao.getAddOnDetailById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List getAllAddOnDetail() {

		return addOnDetailDao.getAllAddOnDetail();
	}

	@Override
	public List getAllAvailAddon(long occ_id) {
		// TODO Auto-generated method stub
		return addOnDetailDao.getAllAvailAddon(occ_id);
	}

}
