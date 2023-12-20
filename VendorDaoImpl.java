package com.amit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amit.entity.Vendor;

@Repository

public class VendorDaoImpl implements VendorDao {

@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public int saveVendor(Vendor vendor) {
		
		int i= (Integer)hibernateTemplate.save(vendor);
		return i;
	}

	
	public Vendor getVendorById(int id) {
	
	Vendor vendor =	hibernateTemplate.get(Vendor.class,id);
	
		return vendor;
	}

	public List<Vendor> getAllVendor() {
	 List<Vendor> list = hibernateTemplate.loadAll(Vendor.class);

		return  list;
	}

	@Transactional
	public void update(Vendor vendor) {
		hibernateTemplate.update(vendor);
		
	}


	@Transactional
	public void deleteVendor(int id) {
Vendor vendor	 =	hibernateTemplate.get(Vendor. class,id);
hibernateTemplate.delete(vendor);
		
		
	}

}
