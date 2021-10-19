 package com.yash.repository;

import java.util.List;

/*
* TripBookingRepository inheriting the methods from JpaRepository
* JpaRepository methods: save(), findById(), findAll(), count(), delete(), deleteById()...
*
* @author usha
* */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yash.domain.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {
	
	/*
	 * this method is used for fetching records of trips on the basis of customer id
	 */
	public List<TripBooking> getAllTripsByCustomer(int customer_id);

 }