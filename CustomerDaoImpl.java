package com.amit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amit.entity.Customer;

@Repository

public class CustomerDaoImpl  implements CustomerDao{
	
	@Autowired
private HibernateTemplate hibernateTemplate;	
	
	@Transactional
	public int saveCustomer(Customer customer) {
		
	int i =	(Integer) hibernateTemplate.save(customer);
		
		return i;
	}

	
	public Customer getCustomerById(int id) {
		
	Customer customer =	hibernateTemplate.get(Customer.class,id);
		
		return customer ;
	}

	
	
	public List<Customer> getAllCustomer() {
		
		List<Customer> list =  hibernateTemplate.loadAll(Customer.class);
		
				return list;
	}

	@Transactional
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
		
	}

	@Transactional
	public void deleteCustomer(int id) {
		Customer customer =	hibernateTemplate.get(Customer.class,id);
hibernateTemplate.delete(customer);		
	}

}
