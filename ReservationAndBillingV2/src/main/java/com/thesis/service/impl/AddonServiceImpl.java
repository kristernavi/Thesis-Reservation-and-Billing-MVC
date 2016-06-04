package com.thesis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.AddOnDao;
import com.thesis.model.AddOn;
import com.thesis.service.AddonService;

@Service
public class AddonServiceImpl implements AddonService {

	@Autowired
	private AddOnDao addOnDao;

	@Override
	@Transactional
	public void saveAddon(AddOn addon) {

		addOnDao.saveAddon(addon);
	}

	@Override
	@Transactional
	public void delete(long addOnId) {

		addOnDao.delete(addOnId);
	}

	
	@Override
	@Transactional(readOnly=true)
	public AddOn getAddOn(long addOnId) {

		return addOnDao.getAddOn(addOnId);
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<AddOn> getAllAddOn() {

		return addOnDao.getAllAddOn();
	}
	



}
