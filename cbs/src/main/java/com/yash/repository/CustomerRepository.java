package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer where email=:em and password=:pd")
	Customer getCustomerEmailAndPassword(@Param("em")String email,@Param("pd")String password);
	
}