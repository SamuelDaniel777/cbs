package com.yash.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Customer;
import com.yash.exception.InvalidData;
import com.yash.repository.CustomerRepository;

@Service
public class CustomerServiceImpl 
{

	@Autowired
	CustomerRepository customerRepository;

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	public Customer requestLogin(String email, String password) throws InvalidData {
		
		try {
			logger.trace("data recieved on service method"+email+password);
			Customer customer = customerRepository.getCustomerEmailAndPassword(email, password);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
