package com.yash.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int adminid;
}
