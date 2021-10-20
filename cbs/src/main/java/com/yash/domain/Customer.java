package com.yash.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Customer Pojo 

@Entity
@Table(name = "customer_data")
public class Customer extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@OneToOne
	@JoinColumn(name = "tripbooking_id")
	TripBooking tripBooking;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the tripBooking
	 */
	public TripBooking getTripBooking() {
		return tripBooking;
	}

	/**
	 * @param tripBooking the tripBooking to set
	 */
	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", tripBooking=" + tripBooking + ", name=" + name + ", password=" + password
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + ", getId()="
				+ getId() + ", getTripBooking()=" + getTripBooking() + ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + ", getAddress()=" + getAddress() + ", getMobileNumber()=" + getMobileNumber()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
