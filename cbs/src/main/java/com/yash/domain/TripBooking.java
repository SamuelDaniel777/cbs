
package com.yash.domain;

/*
* POJO TripBooking class
* containing instance variables, constructors
* getters setters and toString() method
*
* @author usha.more
*/
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "trip_booking")
public class TripBooking {

	/* id stores the value of trip booking id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_Booking_id")
	private int tripBookingId;
	/*
	 * customer stores the value of customer entity - one to one mapped with trip
	 * booking-
	 */
	@OneToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
	/*
	 * driver stores the value of driver entity - many to one mapped with trip
	 * booking
	 */
	@ManyToOne
	private Driver driver;
	/*
	 * fromLocation stores the value of location from where customer has booked the
	 * cab
	 */
	@NotBlank(message = "From location can't be blank")
	@Column(name = "fromLocation", nullable = false)
	private String fromLocation;
	/*
	 * toLocation stores the value of location till where customer has booked the
	 * cab
	 */
	@NotBlank(message = "To location can't be blank")
	@Column(name = "toLocation", nullable = false)
	private String toLocation;
	/*
	 * fromDateTime stores the value of date and time on which the customer has
	 * booked the cab
	 */
	@NotBlank(message = "From Date time can't be blank")
	// @JsonFormat(pattern="yyyy-mm-dd")
	@Column(name = "fromDateTime", nullable = false)
	private LocalDateTime fromDateTime;
	/*
	 * toDateTime stores the value of date and time on which the customer has left
	 * the cab
	 */
	@NotBlank(message = "To Date time can't be blank")
	// @JsonFormat(pattern="yyyy-mm-dd")
	@Column(name = "toDateTime", nullable = false)
	private LocalDateTime toDateTime;
	/* status stores the value of status of the trip */
	@Column(name = "status", nullable = false)
	private boolean status;
	/* distance stores the value of total distance covered by the cab in kms */
	@NotBlank(message = "Distance can't be blank")
	@Column(name = "distanceInKm", nullable = false)
	private float distanceInKm;
	/* bill stores the value of total amount paid by the customer for a trip */
	@Column(name = "bill", nullable = false)
	private float bill;

	/* default constructor */
	public TripBooking() {
	} /* parametrized constructor for initializing values to instance variables */

	/**
	 * @param tripBookingId
	 * @param customer
	 * @param driver
	 * @param fromLocation
	 * @param toLocation
	 * @param fromDateTime
	 * @param toDateTime
	 * @param status
	 * @param distanceInKm
	 * @param bill
	 */
	public TripBooking(int tripBookingId, Customer customer, Driver driver,
			@NotBlank(message = "From location can't be blank") String fromLocation,
			@NotBlank(message = "To location can't be blank") String toLocation,
			@NotBlank(message = "From Date time can't be blank") LocalDateTime fromDateTime,
			@NotBlank(message = "To Date time can't be blank") LocalDateTime toDateTime, boolean status,
			@NotBlank(message = "Distance can't be blank") float distanceInKm, float bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	/**
	 * @return the tripBookingId
	 */
	public int getTripBookingId() {
		return tripBookingId;
	}

	/**
	 * @param tripBookingId the tripBookingId to set
	 */
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the driver
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
	 * @return the fromLocation
	 */
	public String getFromLocation() {
		return fromLocation;
	}

	/**
	 * @param fromLocation the fromLocation to set
	 */
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	/**
	 * @return the toLocation
	 */
	public String getToLocation() {
		return toLocation;
	}

	/**
	 * @param toLocation the toLocation to set
	 */
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	/**
	 * @return the fromDateTime
	 */
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDateTime the fromDateTime to set
	 */
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the toDateTime
	 */
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDateTime the toDateTime to set
	 */
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the distanceInKm
	 */
	public float getDistanceInKm() {
		return distanceInKm;
	}

	/**
	 * @param distanceInKm the distanceInKm to set
	 */
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	/**
	 * @return the bill
	 */
	public float getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(float bill) {
		this.bill = bill;
	}

	/* toString() to print the object of tripbooking */
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customer=" + customer + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
}
