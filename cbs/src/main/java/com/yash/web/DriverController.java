package com.yash.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Driver;
import com.yash.repository.DriverRepository;
import com.yash.serviceimpl.DriverServiceImpl;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverServiceImpl driverServiceImpl;
	
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
