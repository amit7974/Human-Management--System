package com.amit.dao;

import com.amit.entity.Admin;

public interface AdminDao {
	
	public int saveAdmin (Admin admin);
	
	public Admin loginAdmin(String email,String password);
	
	
	
	

}
