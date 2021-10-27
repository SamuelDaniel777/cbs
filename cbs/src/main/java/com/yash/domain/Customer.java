package com.yash.domain;

/*
 * Customer Pojo 
 * author akshay.patil
 * 
 * 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="customer_data")
@CrossOrigin
public class Customer extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customerid;
	
	@Column(name = "customer_role")
	private String role;
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	 
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public Customer()
	{
		super();
	}
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
	 * @param customerid
	 * @param role
	 */
	public Customer(int customerid, String role) {
		super();
		this.customerid = customerid;
		this.role = role;
	}
	
	
	
}
