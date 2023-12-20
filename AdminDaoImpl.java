package com.amit.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amit.entity.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	
@Autowired
public HibernateTemplate hibernateTemplate;



	public int saveAdmin(Admin admin) {
	int i =(Integer) hibernateTemplate.save(admin);
	
		return i;
	}
	
	

	public Admin loginAdmin(String email, String password) {
		// select * from admin where email=? and password=?; ->admin object
		String sql="from Admin where email=:em and password=:pwd";

		Admin ad = (Admin) hibernateTemplate.execute(s->{

	Query q=s.createQuery(sql);
	((org.hibernate.Query) q).setString("em",email);
	((org.hibernate.Query) q).setString("pwd",password);
	return ((org.hibernate.query.Query) q).uniqueResult();
});
	

		return ad;	


}
	
}