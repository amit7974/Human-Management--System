package com.amit.dao;

import java.util.List;

import com.amit.entity.Vendor;

public interface VendorDao {
	
	
	public int saveVendor(Vendor vendor);
	public Vendor getVendorById(int id);
	public List<Vendor> getAllVendor();
	public void update(Vendor vendor);
	public void deleteVendor(int id);

}
