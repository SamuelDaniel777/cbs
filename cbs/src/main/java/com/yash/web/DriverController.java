package com.yash.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Driver;
import com.yash.repository.DriverRepository;

@RestController
public class DriverController {

	@Autowired
	DriverRepository driverRepository;
	
	@PostMapping("/driverSave")
	public String insertDriver(@RequestBody Driver driver)
	{
		driverRepository.save(driver);
		return "Your record is saved successfully";
	}
	
}
