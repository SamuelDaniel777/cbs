package com.yash.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.repository.CustomerRepository;



@Service
public class CustomerServiceImpl 
{

	@Autowired
	CustomerRepository customerRepository;

}
