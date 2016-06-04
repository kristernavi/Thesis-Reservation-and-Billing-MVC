package com.thesis.service;

import java.util.List;

import com.thesis.model.AddOn;

public interface AddonService {
	public void saveAddon(AddOn addon);
	public void delete(long addOnId);
	public AddOn getAddOn(long addOnId);
	public List <AddOn> getAllAddOn();

}
