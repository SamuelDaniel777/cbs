package com.yash.domain;

/*
 * 
 *Admin Pojo and data Abstraction from User
 *@Daniel 
 *
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_data")
public class Admin extends AbstractUser {
	
	//Admin Id Declared and Auto Generated 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminid;
	
	//Admin Id getter Method
	public int getAdminid() {
		return adminid;
	}
	
	//Admin Id setter Method
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	//Admin Super Constructor
	public Admin(int adminid) {
		super();
		this.adminid = adminid;
	}

}
