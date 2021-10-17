package com.yash.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.domain.AbstractUser;
import com.yash.exception.InvalidData;
import com.yash.repository.AdminRepository;

@Service
public class AdminServiceImpl {
		
	@Autowired
	AdminRepository adminRepository;

	public AbstractUser requestLogin(String email, String password) throws InvalidData {
		
		try {
			if (email!=null && password!=null) {
				AbstractUser aUser=adminRepository.getByNameAndPassowrd(email, password);
				return aUser;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidData("Invalid Format Data Passed");
		}

	}
	
}
