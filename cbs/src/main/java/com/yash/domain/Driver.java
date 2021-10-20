package com.yash.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/* Driver POJO */


@Entity
@Table(name = "Driver")
public class Driver extends AbstractUser
{
	/*
	 * Driver Id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	
	/*
	 * Driver Licence Number 
	 */
	@NotBlank(message = "Licence number is required")
	@Size(min = 4, max = 255, message = "please use 4 to 255 characters for licence Number")
	private String licenceNo;

	@OneToOne(cascade=CascadeType.ALL)
	private Cab cab;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=TripBooking.class)
	//@JoinColumn(name = "tripBookingId")
	private Set<TripBooking> tripBooking = new TreeSet<>();
	
	
	/*
	 * Driver Rating
	 */
	@NotBlank(message = "Rating is required")
	private float rating;

	//Constructor
	public Driver(int driverId,
			@NotBlank(message = "Licence number is required") @Size(min = 4, max = 255, message = "please use 4 to 255 characters for licence Number") String licenceNo,
			Cab cab, @NotBlank(message = "Rating is required") float rating) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
	}

	//Default Constructor 
	public Driver() 
	{
		super();
	}

	//Driver Id Getter
	public int getDriverId() {
		return driverId;
	}

	//Driver Id Setter
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	//Licence Number Getter
	public String getLicenceNo() {
		return licenceNo;
	}

	//Licence Number Setter
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	//Cab Getter
	public Cab getCab() {
		return cab;
	}

	//Cab Setter
	public void setCab(Cab cab) {
		this.cab = cab;
	}

	//Rating Getter
	public float getRating() {
		return rating;
	}

	//Rating Setter
	public void setRating(float rating) {
		this.rating = rating;
	}

	//ToString Method
	@Override
	public String toString() 
	{
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ "]";
	}
}
