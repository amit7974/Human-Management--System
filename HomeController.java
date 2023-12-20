package com.amit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.dao.AdminDao;
import com.amit.dao.CustomerDao;
import com.amit.dao.VendorDao;
import com.amit.entity.Admin;
import com.amit.entity.Customer;
import com.amit.entity.Vendor;

@Controller
public class HomeController {
	
	@Autowired
	private VendorDao vendorDao;
	

	@Autowired
	 private CustomerDao customerDao;
		
	@Autowired
	private AdminDao adminDao;
	
	
	@RequestMapping(path = "/home")
	public String  home(Model m) {
		
	List<Customer> list = customerDao.getAllCustomer();
		m.addAttribute("customerList", list);
		
	 List<Vendor> list1 = vendorDao.getAllVendor();
	 m.addAttribute("vendorList", list1);
		return "home";
	}
	
	
	
	@RequestMapping(path = "/addCustomer")
	public String  addCustomer() {
			return "add_customer";
	}
	
	
	// send data view to controller with @ModelAttribute
	@RequestMapping(path = "/createCustomer", method =  RequestMethod.POST)
	public String createCustomer(@ModelAttribute Customer customer,HttpSession session) {
		System.out.println(customer);
		
	int i = customerDao.saveCustomer(customer);
	session.setAttribute("msg", "Register Sucessfully");
		return "redirect:/addCustomer";
	}
	
	
	@RequestMapping(path ="/editCustomer/{id}")
	public String editCustomer(@PathVariable int id, Model m) {
		
		
		Customer customer = customerDao.getCustomerById(id);
		m.addAttribute("customer", customer);
		return "edit_customer";
		
		
	}
	
	@RequestMapping(path = "/updateCustomer",method = RequestMethod.POST)
	
	public String updateCustomer(@ModelAttribute Customer customer,HttpSession session) {
		
		customerDao.update(customer);
		session.setAttribute("msg", " Customer Update Sucessfully");
		return "redirect:/home";
		
	}
	
	@RequestMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id,HttpSession session) {
		customerDao.deleteCustomer(id);
		session.setAttribute("msg", "Customer Delete Sucessfully");

		return "redirect:/home";
	}
	
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
		
	}
	
	
	@RequestMapping("/login")
	public String loginPage() {
		
		
		return "login";
	}
	
	@RequestMapping(path = "/createAdmin",method = RequestMethod.POST)
	public String register(@ModelAttribute Admin admin, HttpSession session) {
		
		System.out.println(admin);
		
		adminDao.saveAdmin(admin);
		session.setAttribute("msg", "Admin Register sucessfully");
		return "redirect:/register";
	}
	
	@RequestMapping(path = "/adminlogin",method = RequestMethod.POST)
	public String login(@RequestParam("email") String em, @RequestParam("password")String pwd,HttpSession session)
	
	{
		
		Admin admin = adminDao.loginAdmin(em, pwd);
		if(admin != null)
		{
		session.setAttribute("loginadmin", admin);
		return "profile";
		}else {
			session.setAttribute("msg","invalid email and password");
			return "redirect:/login";

	}
		
	}
	
	
	
	@RequestMapping("/myProfile")
	public String myProfile() {
		
		
		return "profile";
	}
	
	
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request) {
			
			
HttpSession session = request.getSession();
session.removeAttribute("loginuser");
session.setAttribute("msg", "Logout Sucessfully");
			
			return "login";
		}
	
	
		
		@RequestMapping(path ="/addVendor")

		public String addVendor() {
			
			return "add_vendor";
		}
		

		
			
		@RequestMapping(path = "/createVendor",method = RequestMethod.POST)
		public String createVendor(@ModelAttribute Vendor vendor,HttpSession session) {
			System.out.println(vendor);
			
			int i = vendorDao.saveVendor(vendor);
			session .setAttribute("msg","Register Sucssfiully");
			
			return "redirect:/addVendor";
		}
		
		@RequestMapping(path ="/editVendor/{id}")
		public String editVendor(@PathVariable int id, Model m) {
			
			
			Vendor vendor = vendorDao.getVendorById(id);
			m.addAttribute("vendor", vendor);
			return "edit_vendor";
			
			
		}
		
		@RequestMapping(path ="/updateVendor",method = RequestMethod.POST)
		public String updateVendor(@ModelAttribute Vendor vendor,HttpSession session) {
			
			vendorDao.update(vendor);
			session.setAttribute("msg",  " Vendor Update Sucessfully");
			return "redirect:/home";
		}

		
		
		@RequestMapping("/deleteVendor/{id}")
		
		public String deleteVendor(@PathVariable int id, HttpSession session) {
			
			vendorDao.deleteVendor(id);
			session.setAttribute("msg", "Vendor Delete Successfully");
			return "redirect:/home";
		}
		
	}





