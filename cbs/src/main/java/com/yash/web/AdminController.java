package com.yash.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.domain.AbstractUser;
import com.yash.domain.Admin;
import com.yash.domain.TripBooking;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping("/login")
	public Admin adminLogin(Admin admin,HttpSession session) throws InvalidData {
		logger.trace("admin data recived"+admin.getEmail()+admin.getPassword());
		Admin fromAdminServ=adminServiceImpl.requestLogin(admin.getEmail(),admin.getPassword());
		logger.trace("recevied the valid or null data"+fromAdminServ);
		if (fromAdminServ!=null) {
			session.setAttribute("AdminSession", fromAdminServ);
			
			return fromAdminServ;
		} else {
			return new Admin();
		}
		
	}
	
	@PostMapping("/logout")
	public String adminLogout(HttpSession session) {
		if (session!=null) {
			session.getAttribute("AdminSession");
			session.invalidate();
		} 
		return "Session Expired";
	}
	
	@PostMapping("/updateadmin")
	public void adminUpdate(Admin a) {
		
	}
	
	@PostMapping("/getalltrips")
	public List<TripBooking> getAllTrips() {
		
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
