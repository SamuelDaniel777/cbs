package com.yash.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.domain.AbstractUser;
import com.yash.domain.Admin;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.AdminServiceImpl;

@RestController(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@PostMapping("/login")
	public AbstractUser adminLogin(AbstractUser absUser,HttpSession session) throws InvalidData {
		
		AbstractUser abUser= adminServiceImpl.requestLogin(absUser.getEmail(),absUser.getPassword());
		if (abUser==null) {
			return null;
		} else {
			session.setAttribute("AdminUser", abUser);
			return abUser;
		}
		
	}
	
	@PostMapping("/logout")
	public void adminLogout(Admin a) {
		return ;
	}
	
	@PostMapping("/updateadmin")
	public void adminUpdate(Admin a) {
		
	}
	
	@PostMapping("/getalltrips")
	public List getAllTrips() {
		return null;
	}
	
	@PostMapping("/gettripsdatewise")
	public List getTripsDateWise() {
		return null;
	}
	
	@PostMapping("/gettripsofdays")
	public List getTripsOfDays() {
		return null;
	}
	
}
