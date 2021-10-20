package com.yash.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.domain.Driver;
import com.yash.exception.InvalidData;
import com.yash.repository.DriverRepository;

@Service
public class DriverServiceImpl {
	
	@Autowired
	DriverRepository driverRepository;
	
	
	public Driver requestLogin(String email, String password) throws InvalidData {

		try {
			Driver driver= driverRepository.getByNameAndPassowrd(email, password);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
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
