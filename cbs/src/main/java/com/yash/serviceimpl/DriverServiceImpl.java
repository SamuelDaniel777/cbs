package com.yash.serviceimpl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.domain.Driver;
import com.yash.repository.DriverRepository;

@Service
public class DriverServiceImpl {
	
	@Autowired
	DriverRepository driverRepository;
	
	//Create
	public boolean registerDriver(Driver driver)
	{
		try {
		driverRepository.save(driver);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Delete
	public Driver deleteDriver(int id)
	{
		try {
		driverRepository.deleteById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
