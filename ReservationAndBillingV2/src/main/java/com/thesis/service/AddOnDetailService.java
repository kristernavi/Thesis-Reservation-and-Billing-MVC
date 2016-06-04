package com.thesis.service;

import java.util.List;

import com.thesis.model.AddOnDetail;

public interface AddOnDetailService {
	public void save(AddOnDetail addOnDetail);
	public void delete(long id);
	public AddOnDetail getAddOnDetailById(long id);
	public List getAllAddOnDetail();
	public List getAllAvailAddon(long occ_id);


}
