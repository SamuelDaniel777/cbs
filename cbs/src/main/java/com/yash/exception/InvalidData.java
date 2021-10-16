package com.yash.exception;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_data")
public class InvalidData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminid;
	
}
