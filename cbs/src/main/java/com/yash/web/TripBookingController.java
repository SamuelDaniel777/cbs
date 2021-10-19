package com.yash.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.domain.Customer;
import com.yash.domain.TripBooking;
import com.yash.repository.TripBookingRepository;
import com.yash.serviceimpl.TripBookingServiceImpl;

/**
 * controller for project class mapping the URL from here 
 * @author usha.more
 *
 */
@RestController
//@RequestMapping("/tripBooking")
@CrossOrigin   
//(origins = "http://localhost:8081/cbs/")
public class TripBookingController 
{
	@Autowired
	 TripBookingServiceImpl tripbookingimpl;
	@Autowired
 TripBookingRepository tripbookingRepository;
	
	
	@PostMapping("/save")//http://localhost:8081/cbs/save
	public String createTrip(@RequestBody TripBooking tripBooking)
	{

	tripbookingRepository.save(tripBooking );
	return "Trip  inserted";
	}
	
	@GetMapping("/list")//http://localhost:8081/cbs/list
	public List<TripBooking > getAllTrip()
	{
	return (List<TripBooking >) tripbookingRepository.findAll() ;
	}
   
//	@GetMapping("/custlist")//http://localhost:8081/cbs/list
//	public List<TripBooking > getAllTripbycustomer()
//	{
//	return (List<TripBooking >) tripbookingRepository.findAll() ;
//	}
	
	@GetMapping()//http://localhost:8081/cbs/
	public  List<TripBooking > findTripByCustomer(@PathVariable int customerid)
	{
	    List<TripBooking> tblist = tripbookingimpl.getAllTripsByCustomer(customerid);
	      return tblist;
	}
	
	@DeleteMapping("/{id}")
	public String deletetripbyid(@PathVariable("id") int id ) 
	{
		try {
		tripbookingRepository.deleteById(id) ;
		return "delete id";	
	}
		catch(Exception e) {
			e.printStackTrace();
		 }
		return null;
	 }
	
}
