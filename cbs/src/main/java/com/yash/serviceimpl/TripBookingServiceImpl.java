
package com.yash.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.TripBooking;
import com.yash.repository.TripBookingRepository;
import com.yash.service.TripBookingService;

@Service
public class TripBookingServiceImpl //implements TripBookingService 
{
	@Autowired
	private TripBookingRepository tbrepo;

//	@Override
//	public List<TripBooking> getAllTripsByCustomer(int customer_id) {
//		List<TripBooking> custblist = new ArrayList<TripBooking>();
//		List<TripBooking> tlist = tbrepo.findAll();
//		for (TripBooking tb : tlist) {
//			if (tb.getCustomer().getCustomerid() == customer_id) {
////for loop
//				custblist.add(tb);
//			}
//		}
//		return custblist;
//	}

	
	public List<TripBooking> getAllTripsByCustomer(int customer_id) {
		 List<TripBooking> list = tbrepo.getAllTripsByCustomer(customer_id);
		 return list;
	
	 }	
}
//	@Override
//	public TripBooking calculateBill(int customer_id) {
//		TripBooking tb = new TripBooking();
//		if (tb.getCustomer().getCustomerid() == customer_id) {
//			float distance = tb.getDistanceInKm();
//			float cost = tb.getDriver().getCab().getPerkmRate();
//			float bill = distance * cost;
//			tb.setBill(bill);
//			return tb;
//		}
//		return null;
//	}
//}
