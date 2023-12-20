package com.amit.dao;

import java.util.List;

import com.amit.entity.Customer;

public interface CustomerDao {
	
	public int saveCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public List<Customer> getAllCustomer();
	
	public void update(Customer customer);
	
	public void deleteCustomer(int id);

}
