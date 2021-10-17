package com.yash.web;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Admin;

@RestController(value = "/admin")
public class AdminController {
	
	@PostMapping("/login")
	public Admin adminLogin(Admin a) {
		return null;
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
