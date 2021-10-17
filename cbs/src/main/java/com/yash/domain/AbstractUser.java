package com.yash.domain;

/*
*Abstract User Class For Common Fields 
*Author:-@Daniel
*/

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractUser {
	
	//Field user name(Mandatory Field)
	@Column(nullable = false)
	protected String name;
	
	//Field User Passowrd(Mandatory Field)
	@Column(nullable = false)
	protected String password;
	
	//Field User Address(Mandatory Field)
	@Column(nullable = false)
	protected String address;
	
	//Field User MobileNumber(Mandatory Field, Unique Field)
	@Column(nullable = false, unique = true)
	protected String mobileNumber;
	
	//Field User email(Mandatory Field, Unique Field)
	@Column(nullable = false, unique = true)
	protected String email;

	//Getters and Setters for the userfields
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
