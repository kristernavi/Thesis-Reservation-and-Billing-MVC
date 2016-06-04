package com.thesis.dao;
import java.util.List;

import com.thesis.model.AddOn;

public interface AddOnDao {
	public void saveAddon(AddOn addon);
	public void delete(long addOnId);
	public AddOn getAddOn(long addOnId);
	public List <AddOn> getAllAddOn();

}
