package com.yash.web;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yash.domain.Customer;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.CustomerServiceImpl;


@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/login")
	public Customer adminLogin(Customer customer,HttpSession session) throws InvalidData {
		logger.trace("data recieved on controller"+customer);
		Customer fromCustomer=customerServiceImpl.requestLogin(customer.getEmail(),customer.getPassword());
		logger.trace("data recieved from service"+fromCustomer);
		if (fromCustomer!=null) {
			session.setAttribute("customerSession", fromCustomer);
			return fromCustomer;
		} else {
			return null;
		}
		
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String getList(ModelMap model) 
//	{
//		List<Customer> custlist = 
//		model.addAttribute("custlist", custlist);
//		return "custlist";
//	}

}
