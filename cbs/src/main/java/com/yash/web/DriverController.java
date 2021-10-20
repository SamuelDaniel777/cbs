package com.yash.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Driver;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.DriverServiceImpl;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverServiceImpl driverServiceImpl;
	
	@PostMapping("/login")
	public Driver adminLogin(Driver driver,HttpSession session) throws InvalidData {
		Driver fromDriver = driverServiceImpl.requestLogin(driver.getEmail(),driver.getPassword());
		if (fromDriver!=null) {
			session.setAttribute("driverSession", fromDriver);
			return fromDriver;
		} else {
			return null;
		}
		
	}
	
	
	
	@PostMapping("/insertDriver")
	public String insertDriver(Driver driver)
	{
		driverServiceImpl.registerDriver(driver);
		return "Your record is saved successfully";
	}
	
	
	
	
//	@GetMapping("/viewDriver/{driverId}")
//	public Optional<Driver> viewDriver(@PathVariable("driverId") int id)
//	{
//		return driverRepository.findById(id);
//	}
	
}
