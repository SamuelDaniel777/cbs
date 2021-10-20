package com.yash.serviceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Admin;
import com.yash.exception.InvalidData;
import com.yash.repository.AdminRepository;

@Service
public class AdminServiceImpl {

	@Autowired
	AdminRepository adminRepository;

	Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);

	//Admin Login Service Logic
	public Admin requestLogin(String email, String password) throws InvalidData {

		try {
			
			logger.trace("admin data recieved at AdminServiceImpl"+email+password);
			Admin admin = adminRepository.getByNameAndPassowrd(email, password);
			logger.trace("admin details"+admin);
			return admin;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidData("Data Does not exist");
		}
		
	}
	
}
