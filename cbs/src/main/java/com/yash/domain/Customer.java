package com.yash.domain;

import javax.persistence.CascadeType;

//Customer Pojo 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_data")
public class Customer extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customerid;

	@OneToOne
	@JoinColumn(name = "trip_book_id")
	private TripBooking tripbooking;
	/**
	 * @param customerid
	 */
	public Customer(int customerid) {
		super();
		this.customerid = customerid;
	}

	/**
	 * @return the customerid
	 */
	public int getCustomerid() {
		return customerid;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
}
