
package com.yash.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.domain.Customer;
import com.yash.domain.Driver;
import com.yash.domain.TripBooking;
import com.yash.repository.TripBookingRepository;

@Service
public class TripBookingServiceImpl {
	
	@Autowired
	TripBookingRepository tbrepo;

	Logger logger = LoggerFactory.getLogger(TripBookingServiceImpl.class);

	public TripBooking registerOrUpdateCustomerBooking(TripBooking tb, Customer customer) {
		try {
			logger.trace("method called tripbooking data" + tb);
			tb.setCustomer(customer);
			tbrepo.save(tb);
			TripBooking tripbook = tbrepo.getById(tb.getTripBookingId());
			return tripbook;

			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean deleteTripById(TripBooking tb) {
		try {
			tbrepo.deleteById(tb.getTripBookingId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<TripBooking> viewAllTripsById(Customer customer) {
		try {
			List<TripBooking> tblist = tbrepo.getTripsByCustomerId(customer);
			logger.trace("returning null or list reference of type tripbooking" + tblist);
			return tblist;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public List<TripBooking> getAllTrips() {
		List<TripBooking>tList=tbrepo.getAllTripBookingData();
		return tList;
	}

	public Boolean setDriverDetails(TripBooking tb, Driver sDriver) {
		try {
			TripBooking tBooking= tbrepo.getById(tb.getTripBookingId());
			tBooking.setDriver(sDriver);
			tBooking.setStatus(true);
			tbrepo.save(tBooking);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
