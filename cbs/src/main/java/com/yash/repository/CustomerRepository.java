package com.yash.repository;

/*
 * customer Repository
 * author akshay.patil  
 * 
 */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yash.domain.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> 
{
	Optional<Customer> findById(int id);

	public Customer findCustomerByName(String name);

	public Customer findByemail(String email);

}