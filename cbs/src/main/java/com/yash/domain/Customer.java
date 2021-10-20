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
	
	boolean customerStatus;
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

	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}

	
}
