package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	
}